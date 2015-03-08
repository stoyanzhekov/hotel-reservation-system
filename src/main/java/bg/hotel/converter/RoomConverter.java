package bg.hotel.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.web.jsf.FacesContextUtils;

import bg.hotel.entities.Room;
import bg.hotel.services.AdminService;

public class RoomConverter implements Converter {
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		AdminService adminService = (AdminService) FacesContextUtils.getWebApplicationContext(context).getBean("adminService");
		return adminService.findById(new Long(value));
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Room room = (Room) value;
		return room.getId().toString();
	}

}
