package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

import models.*;
import java.util.ArrayList;

public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent e){
		ServletContext sc = e.getServletContext();

		ArrayList<City> cities = City.collectCities();
		ArrayList<State> states = State.collectStates();
		ArrayList<Room> rooms = Room.collectAllRooms();

		sc.setAttribute("cities",cities);
		sc.setAttribute("states",states);
		sc.setAttribute("rooms",rooms);
	}

	public void contextDestroyed(ServletContextEvent e){
		
	}
}