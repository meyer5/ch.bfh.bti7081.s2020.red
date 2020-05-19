package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.gui.patient.newEntry.EntryViewController;



/**
 * View for patient after login
 * with overwiew
 * and diary entry option
 * 
 * @author Remo
 *
 */
@Route(value = "del-patient-main")
public class ZZZ_del_PatientMainUI extends AppLayout implements RouterLayout {

	private static final long serialVersionUID = -2650280342702537272L;

		
	public ZZZ_del_PatientMainUI() {
		
		final boolean touchOptimized = true;
		
		 // Header of the menu (the navbar)
		
		// menu toggle
		final DrawerToggle drawerToggle = new DrawerToggle();
		drawerToggle.addClassName("menu-toggle");
		addToNavbar(touchOptimized, drawerToggle);
		
		
		// image, logo TODO
		final HorizontalLayout top = new HorizontalLayout();
		top.setDefaultVerticalComponentAlignment(Alignment.CENTER);
		top.setClassName("menu-header");
		
		
		// Set Image and title of App 
        final String resolvedImage = VaadinService.getCurrent().resolveResource(
                "img/table-logo.png", VaadinSession.getCurrent().getBrowser());

        final Image image = new Image(resolvedImage, "");
        final Label title = new Label("Diary");
        top.add(image, title);
        top.add(title);
        addToNavbar(touchOptimized, top);
		
				
		// Navigation items
        //TODO change pictures
		addToDrawer(createMenuLink(EntryViewController.class, EntryViewController.VIEW_NAME, VaadinIcon.INFO_CIRCLE.create()));
				

	}

	// A link that handles navigation internally using Router
	// instead of loading a new page in the browser
	private RouterLink createMenuLink(Class<? extends Component> viewClass, String caption, Icon icon) {
		final RouterLink routerLink = new RouterLink(null, viewClass);
		routerLink.setClassName("menu-link");
		routerLink.add(icon);
		routerLink.add(new Span(caption));
		icon.setSize("24px");
		return routerLink;
	}
	
	
	

}
