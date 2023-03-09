package com.trevorjmoore.randleague.views;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

//Index of the League Randomizer
@Route("/")
public class HomeView extends AppLayout {

    public HomeView() {
        H1 title = new H1("League of Random");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)");

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
