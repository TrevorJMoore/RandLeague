package com.trevorjmoore.randleague.views;

import com.trevorjmoore.randleague.models.Champion;
import com.trevorjmoore.randleague.models.Item;
import com.trevorjmoore.randleague.models.Rune;
import com.trevorjmoore.randleague.repositories.ChampionRepository;
import com.trevorjmoore.randleague.repositories.ItemRepository;
import com.trevorjmoore.randleague.repositories.RuneRepository;
import com.trevorjmoore.randleague.repositories.SummonerRepository;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

//Home page of the League Randomizer
@Route("/")
@RestController
public class HomeView extends AppLayout {

    @Autowired
    private ChampionRepository championRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RuneRepository runeRepository;
    @Autowired
    private SummonerRepository summonerRepository;

    VerticalLayout pageContent = new VerticalLayout();
    public HomeView() {


        H1 title = new H1("Randomizer");
        title.getStyle().set("font-size", "var(--lumo-font-size-xxl)");


        Button generateButton = new Button("Generate",
                event -> generateLoadout());

        pageContent.add(generateButton);
        pageContent.setAlignItems(FlexComponent.Alignment.CENTER);

        setContent(pageContent);
        /*Tabs tabs = getTabs();

        H2 viewTitle = new H2("View title");
        Paragraph viewContent = new Paragraph("View content");

        Div content = new Div();
        content.add(viewTitle, viewContent);*/


        HorizontalLayout navBar = new HorizontalLayout();
        navBar.setWidth("100%");
        navBar.add(title);
        //navBar.add(tabs);
        navBar.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        addToNavbar(true, navBar);

        //setContent(content);
    }


    /*
    A loadout has:
        1 Champion
        6 Items (1 Boot, 1 Mythic)
        2 Summoner Spells
        4 Main Tree Runes (1 Keystone, 1 Third, 1 Second, 1 First), 2 Secondary Tree Runes (1 Second, 1 First), and 3 Bonus Runes (1, 1, 1)
     */
    private void generateLoadout() {
        Random randomNumber = new Random();

        //Obtain random champion
        Optional<Champion> selectedChamp = championRepository.findById(
                randomNumber.nextInt((int)championRepository.count())
        );
        if (!selectedChamp.isPresent()) {
            System.out.println("Error: Unspecified Champion Selected.");
            return;
        }

        //Obtain random items
        //Need to pick 1 Mythic and 1 Boot
        List<Item> selectedItems = new ArrayList<Item>();

        List<Item> mythics = itemRepository.findByIsMythic(true);
        List<Item> boots = itemRepository.findByIsBoot(true);
        List<Item> legendaries = itemRepository.findByIsMythicAndIsBoot(false, false);

        //Add a mythic to the items
        selectedItems.add(mythics.get(randomNumber.nextInt(mythics.size())));
        //Add boots to the items
        selectedItems.add(boots.get(randomNumber.nextInt(boots.size())));

        //Add 4 legendaries to the items
        for (int i = 0; i < 4; i++) {
            int idx;

            do {
                idx = randomNumber.nextInt(legendaries.size());
            } while (selectedItems.contains(legendaries.get(idx)));

            selectedItems.add(legendaries.get(idx));
        }

        //Obtain primary rune tree
        List<Rune> primaryRunes = new ArrayList<Rune>();
        List<Rune> tempRunes = runeRepository.findByRuneTier(0);

        //Get keystone rune
        primaryRunes.add(tempRunes.get(randomNumber.nextInt(tempRunes.size())));

        //Obtain the last three random runes from same rune family as keystone
        for (int i = 1; i < 4; i++) {
            tempRunes = runeRepository.findByRuneFamilyIgnoreCaseAndRuneTier(primaryRunes.get(0).getRuneFamily(), i);
            primaryRunes.add(tempRunes.get(randomNumber.nextInt(tempRunes.size())));
        }
        
        //Obtain secondary rune tree
        List<Rune> secondaryRunes = new ArrayList<Rune>();
        //Obtain a random secondary rune family that is different from primary rune family

        for (int i = 0; i < 2; i++) {
            tempRunes = runeRepository.findByRuneTier(i+2);
            int runeId;
            if (secondaryRunes.isEmpty()) {
                do {
                    runeId = randomNumber.nextInt(runeRepository.findByRuneTier(i + 2).size());
                } while (tempRunes.get(runeId).getRuneFamily().equals(primaryRunes.get(i).getRuneFamily()));
                secondaryRunes.add(tempRunes.get(runeId));
            }
            else {
                secondaryRunes.add(
                        runeRepository.findByRuneFamilyIgnoreCaseAndRuneTier(secondaryRunes.get(0).getRuneFamily(), i+2)
                                .get(randomNumber.nextInt(
                                        runeRepository.findByRuneFamilyIgnoreCaseAndRuneTier(
                                                secondaryRunes.get(0).getRuneFamily(), i+2).size()))
                );
            }
        }
        
        //List<Rune> primaryRunes
        //List<Rune> secondaryRunes
        //List<Item> selectedItems
        //Optional<Champion> selectedChampion.get()
        System.out.println("Champion: " + selectedChamp.get().getName());
        for (int i = 0; i < primaryRunes.size(); i++)
            System.out.println("Primary runes: " + primaryRunes.get(i).getRuneName());
        for (int i = 0; i < secondaryRunes.size(); i++)
            System.out.println("Secondary runes: " + secondaryRunes.get(i).getRuneName());
        for (int i = 0; i < selectedItems.size(); i++)
            System.out.println("Item " + i + ": " + selectedItems.get(i).getItemName());

        pageContent.add(new H1("Testing Testing 123"));
    }

    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.getStyle().set("margin", "auto");
        tabs.add(createTab("Dashboard"), createTab("Orders"),
                createTab("Customers"), createTab("Products"));
        return tabs;
    }

    private Tab createTab(String viewName) {
        RouterLink link = new RouterLink();
        link.add(viewName);
        // Demo has no routes
        // link.setRoute(viewClass.java);
        link.setTabIndex(-1);

        return new Tab(link);
    }

}
