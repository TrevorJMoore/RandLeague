package com.trevorjmoore.randleague.views;

import com.trevorjmoore.randleague.models.Champion;
import com.trevorjmoore.randleague.models.Item;
import com.trevorjmoore.randleague.models.Rune;
import com.trevorjmoore.randleague.models.Summoner;
import com.trevorjmoore.randleague.repositories.ChampionRepository;
import com.trevorjmoore.randleague.repositories.ItemRepository;
import com.trevorjmoore.randleague.repositories.RuneRepository;
import com.trevorjmoore.randleague.repositories.SummonerRepository;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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


        H1 title = new H1("League Randomizer");
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

    private void generateLoadout() {
        /*
        TODO: Break generateLoadout() into smaller functions
        for generating champion, items, runes, and summoners.
        Keeping it in one method causes readability to reduce.
        Also the rune generation needs to be more readable.
        Ex:*/
        pageContent.removeAll();
        Champion selectedChamp = generateChampion();
        List<Item> selectedItems = generateItems();
        List<Rune> primaryRunes = generatePrimaryRunes();
        List<Rune> secondaryRunes = generateSecondaryRunes(primaryRunes);
        List<Summoner> selectedSummoners = generateSummoners();

        // Main webapp container
        VerticalLayout mainContainer = new VerticalLayout();
        // Title container (Champion: #Name)
        HorizontalLayout titleBarContainer = new HorizontalLayout();

        // Main content container
        HorizontalLayout contentContainer = new HorizontalLayout();
            // List of items to purchase (3x2 grid)
            VerticalLayout itemsContainer = new VerticalLayout();
            // List of summoners in 2x1 and runes in 2x4
            VerticalLayout augmentsContainer = new VerticalLayout();
                VerticalLayout summonersContainer = new VerticalLayout();
                VerticalLayout runesContainer = new VerticalLayout();

        // Footer container
        HorizontalLayout bottomContainer = new HorizontalLayout();

        titleBarContainer.add(new H1("Champion: " + selectedChamp.getName()));
        titleBarContainer.setSizeFull();
        titleBarContainer.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        titleBarContainer.setAlignItems(FlexComponent.Alignment.CENTER);



        // Left hand side of webapp creation
        itemsContainer.setAlignItems(FlexComponent.Alignment.CENTER);

        VerticalLayout itemsTitle = new VerticalLayout();
        itemsTitle.add(new H2("Items"));
        itemsTitle.setAlignItems(FlexComponent.Alignment.CENTER);
        itemsTitle.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        itemsContainer.add(itemsTitle);

        for (int i = 0; i< selectedItems.size(); i++)
            itemsContainer.add(new ListItem(selectedItems.get(i).getItemName()));


        // Right hand side of webapp creation
        summonersContainer.setAlignItems(FlexComponent.Alignment.CENTER);
        summonersContainer.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        /*VerticalLayout summonersTitle = new VerticalLayout();
        summonersTitle.add(new H2("Summoners"));
        summonersTitle.setAlignItems(FlexComponent.Alignment.CENTER);
        summonersTitle.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);*/
        summonersContainer.add(new H2("Summoners"));

        HorizontalLayout summonerSpellContainer = new HorizontalLayout();

        for (int i = 0; i < selectedSummoners.size(); i++)
            summonerSpellContainer.add(new Text(selectedSummoners.get(i).getSummonerName() + " "));
        summonersContainer.add(summonerSpellContainer);

        VerticalLayout runesTitle = new VerticalLayout();
        runesTitle.add(new H2("Runes"));
        runesTitle.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        runesTitle.setAlignItems(FlexComponent.Alignment.CENTER);
        runesContainer.add(runesTitle);


        HorizontalLayout mainRunesContainer = new HorizontalLayout();
        VerticalLayout primaryRunesContainer = new VerticalLayout();
        VerticalLayout secondaryRunesContainer = new VerticalLayout();

        primaryRunesContainer.add(new H3(primaryRunes.get(0).getRuneFamily()));
        for (int i = 0; i < primaryRunes.size(); i++)
            primaryRunesContainer.add(new ListItem(primaryRunes.get(i).getRuneName()));
        primaryRunesContainer.setAlignItems(FlexComponent.Alignment.CENTER);
        mainRunesContainer.add(primaryRunesContainer);


        secondaryRunesContainer.add(new H3(secondaryRunes.get(0).getRuneFamily()));
        for (int i = 0; i < secondaryRunes.size(); i++)
            secondaryRunesContainer.add(new ListItem(secondaryRunes.get(i).getRuneName()));
        secondaryRunesContainer.setAlignItems(FlexComponent.Alignment.CENTER);
        mainRunesContainer.add(secondaryRunesContainer);
        runesContainer.add(mainRunesContainer);

        Button regenerateButton = new Button("Regenerate",
                event -> generateLoadout());

        augmentsContainer.add(summonersContainer);
        augmentsContainer.add(runesContainer);

        contentContainer.add(itemsContainer);
        contentContainer.add(augmentsContainer);

        bottomContainer.add(regenerateButton);

        mainContainer.add(titleBarContainer);
        mainContainer.add(contentContainer);
        mainContainer.add(bottomContainer);



        pageContent.removeAll();
        pageContent.add(mainContainer);


        //List<Rune> primaryRunes
        //List<Rune> secondaryRunes
        //List<Item> selectedItems
        //Optional<Champion> selectedChampion.get()
        /*
        System.out.println("Champion: " + selectedChamp.getName());
        for (int i = 0; i < primaryRunes.size(); i++)
            System.out.println("Primary runes: " + primaryRunes.get(i).getRuneName());
        for (int i = 0; i < secondaryRunes.size(); i++)
            System.out.println("Secondary runes: " + secondaryRunes.get(i).getRuneName());
        for (int i = 0; i < selectedItems.size(); i++)
            System.out.println("Item " + i + ": " + selectedItems.get(i).getItemName());

        pageContent.add(new H1("Champion: " + selectedChamp.getName()));

        pageContent.add(new Paragraph("Summoners: "));
        for (int i = 0; i < selectedSummoners.size(); i++) {
            pageContent.add(new Text(selectedSummoners.get(i).getSummonerName() + " "));
        }

        pageContent.add(new Paragraph("Items: "));


        for (int i = 0; i< selectedItems.size(); i++)
            pageContent.add(new ListItem(selectedItems.get(i).getItemName()));

        pageContent.add(new Paragraph("Runes: "));
        pageContent.add(new Paragraph("Primary Runes: " + primaryRunes.get(0).getRuneFamily()));
        for (int i = 0; i < primaryRunes.size(); i++)
            pageContent.add(new ListItem(primaryRunes.get(i).getRuneName()));
        pageContent.add(new Paragraph("Secondary Runes: " + secondaryRunes.get(0).getRuneFamily()));
        for (int i = 0; i < secondaryRunes.size(); i++)
            pageContent.add(new ListItem(secondaryRunes.get(i).getRuneName()));


        Button regenerateButton = new Button("Regenerate",
                event -> generateLoadout());
        pageContent.add(regenerateButton);*/

    }

    /*
    A loadout has:
        1 Champion
        6 Items (1 Boot, 1 Mythic)
        2 Summoner Spells
        4 Main Tree Runes (1 Keystone, 1 Third, 1 Second, 1 First), 2 Secondary Tree Runes (1 Second, 1 First), and 3 Bonus Runes (1, 1, 1)
     */
    private Champion generateChampion() {
        Random randomNumber = new Random();
        Optional<Champion> selectedChamp = championRepository.findById(
                randomNumber.nextInt((int)championRepository.count())
        );
        if (!selectedChamp.isPresent()) {
            System.out.println("Error: Unspecified Champion Selected.");
            return null;
        }
        return selectedChamp.get();
    }

    private List<Item> generateItems() {
        Random randomNumber = new Random();
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

        return selectedItems;
    }

    private List<Rune> generatePrimaryRunes() {
        Random randomNumber = new Random();
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
        return primaryRunes;
    }

    private List<Rune> generateSecondaryRunes(List<Rune> primaryRunes) {
        Random randomNumber = new Random();
        List<Rune> tempRunes;
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
        return secondaryRunes;
    }

    private List<Summoner> generateSummoners() {
        //Select two summoners
        List<Summoner> summonerList = new ArrayList<Summoner>();
        Random randomNumber = new Random();

        for (int i = 0; i < 2; i++) {
            int idx;
            do {
                idx = randomNumber.nextInt((int)summonerRepository.count());
            } while (summonerList.contains(summonerRepository.findById(idx).get()));

            summonerList.add(summonerRepository.findById(idx).get());
        }
        return summonerList;
    }


}
