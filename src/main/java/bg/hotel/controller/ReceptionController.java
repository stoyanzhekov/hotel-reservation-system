package bg.hotel.controller;

import bg.hotel.entities.Room;
import bg.hotel.services.ReceptionService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Scope("session")
@Named(value="receptionMB")
public class ReceptionController {

    @Inject
    private ReceptionService receptionService;

	private PeriodDto period = new PeriodDto();
    private List<Room> rooms = new ArrayList<>();
    private List<DynamicRoom> dynamicRooms = new ArrayList<>();
    private List<ColumnModel> columns;

    private String columnTemplate = "number day1 day2 day3 day4 day5 day6 day7";

    @PostConstruct
    public void init() {
        initRooms();

        createDynamicColumns();
    }

	public PeriodDto getPeriod() {
		return period;
	}

	public void setPeriod(PeriodDto period) {
		this.period = period;
	}

    public void initRooms() {
        rooms = receptionService.fetchAllRooms();
        for (Room r :rooms) {
            DynamicRoom dr = new DynamicRoom();
            dr.number = r.getNumber();
            dr.day1 = "v";
            dr.day2 = "x";
            dr.day3 = "x";
            dr.day4 = "x";
            dr.day5 = "v";
            dr.day6 = "v";
            dr.day7 = "v";
            dynamicRooms.add(dr);
        }

    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    private void createDynamicColumns() {
        String[] columnKeys = columnTemplate.split(" ");
        columns = new ArrayList<ColumnModel>();

        for (String columnKey : columnKeys) {
            String key = columnKey.trim();

            columns.add(new ColumnModel(columnKey.toUpperCase(), columnKey));
        }
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    static public class ColumnModel implements Serializable {

        private String header;
        private String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }
    }

    static public class DynamicRoom implements Serializable {
        private int number;
        private String day1;
        private String day2;
        private String day3;
        private String day4;
        private String day5;
        private String day6;
        private String day7;

        public int getNumber() {
            return number;
        }

        public String getDay1() {
            return day1;
        }

        public void setDay1(String day1) {
            this.day1 = day1;
        }

        public String getDay2() {
            return day2;
        }

        public void setDay2(String day2) {
            this.day2 = day2;
        }

        public String getDay3() {
            return day3;
        }

        public void setDay3(String day3) {
            this.day3 = day3;
        }

        public String getDay4() {
            return day4;
        }

        public void setDay4(String day4) {
            this.day4 = day4;
        }

        public String getDay5() {
            return day5;
        }

        public void setDay5(String day5) {
            this.day5 = day5;
        }

        public String getDay6() {
            return day6;
        }

        public void setDay6(String day6) {
            this.day6 = day6;
        }

        public String getDay7() {
            return day7;
        }

        public void setDay7(String day7) {
            this.day7 = day7;
        }
    }

    public List<DynamicRoom> getDynamicRooms() {
        return dynamicRooms;
    }

    public void setDynamicRooms(List<DynamicRoom> dynamicRooms) {
        this.dynamicRooms = dynamicRooms;
    }
}
