package service;

import domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @FXML
    private TableView teacherTableView;
    @FXML
    private TableColumn<Teacher, String> idTeacher;
    @FXML
    private TableColumn<Teacher, String> nameTeacher;
    @FXML
    private TableColumn<Teacher, String> rankTeacher;
    @FXML
    private TableColumn<Teacher, String> oldIdTeacher;
    @FXML
    private TextField idTeacherText;
    @FXML
    private TextField nameTeacherText;
    @FXML
    private TextField rankTeacherText;
    @FXML
    private TextField oldIdTeacherText;
    @FXML
    private Button addTeacherButton;
    @FXML
    private Button deleteTeacherButton;
    @FXML
    private Button updateTeacherButton;
    @FXML
    private TableView disciplineTableView;
    @FXML
    private TableColumn<Teacher, String> idDiscipline;
    @FXML
    private TableColumn<Teacher, String> nameDiscipline;
    @FXML
    private TableColumn<Teacher, String> rankDiscipline;
    @FXML
    private TableColumn<Teacher, String> oldIdDiscipline;
    @FXML
    private TextField idDisciplineText;
    @FXML
    private TextField nameDisciplineText;
    @FXML
    private TextField rankDisciplineText;
    @FXML
    private TextField oldIdDisciplineText;
    @FXML
    private Button addDisciplineButton;
    @FXML
    private Button deleteDisciplineButton;
    @FXML
    private Button updateDisciplineButton;
    @FXML
    private TableView timeslotTableView;
    @FXML
    private TableColumn<Timeslot, String> day;
    @FXML
    private TableColumn<Timeslot, String> start;
    @FXML
    private TableColumn<Timeslot, String> end;
    @FXML
    private TableView subgroupTableView;
    @FXML
    private TableColumn<Subgroup, String> name;
    @FXML
    private ListView activityListView;
    @FXML
    private TableColumn<Activity, String> id;
    @FXML
    private ListView roomListView;
    @FXML
    private TableColumn<Activity, String> idRoom;
    @FXML
    private Button associateButton;
    @FXML
    private TextField idSubjectText;
    @FXML
    private TextField rankTextField;
    @FXML
    private TextField roomIdTextField;
    @FXML
    private TextField formationTextField;
    @FXML
    private ListView<Entity> streamsListView;
    @FXML
    private ListView<Activity> activitiesListView;
    @FXML
    private ListView<Subject> associationsListView;
    @FXML
    private TextField activityIdTextField;
    @FXML
    private TextField typeTextField;

    @FXML
    private ListView<Subgroup> groupListView;

    @FXML
    private Label groupLabel;

    @FXML
    private ListView<String> TTdayListView;

    @FXML
    private ListView<String> TTintervalListView;

    @FXML
    private ListView<String> TTsubjectListView;

    @FXML
    private ListView<String> TTtypeListView;

    @FXML
    private ListView<String> TTteacherListView;

    @FXML
    private ListView<String> TTroomListView;


    @FXML
    void showTimetableButtonHandler(ActionEvent event) {
        String subgroup = groupListView.getSelectionModel().getSelectedItem().getName();
        System.out.println(subgroup);
//        ArrayList<Subject> subjects = new ArrayList<>();
//        for(Subject s: service.getSubjectRepo().getEntities())
//        {
//            if(s.getSubgroup().getName().equals(subgroup))
//                subjects.add(s);
//
//        }

        List<Subject> orderedSubjects =
                service.getSubjectRepo().getEntities().stream()
                        .filter(subject -> subject.getSubgroup().getName().equals(subgroup))
                        .sorted((sj1, sj2) -> sj1.getTimeslot().compareTo(sj2.getTimeslot()))
                        .collect(Collectors.toList());
        System.out.println(orderedSubjects.size());

        ArrayList<String> days = new ArrayList<>();
        ArrayList<String> intervals = new ArrayList<>();
        ArrayList<String> disciplines = new ArrayList<>();
        ArrayList<String> types = new ArrayList<>();
        ArrayList<String> teachers = new ArrayList<>();
        ArrayList<String> rooms = new ArrayList<>();

        for(Subject s: orderedSubjects)
        {
            days.add(s.getTimeslot().getDay());
            intervals.add(s.getTimeslot().getStart()+" - "+s.getTimeslot().getEnd());
            for(Activity a: service.getActivityRepo().getEntities())
            {
                if(a.getId()== s.getActivityId())
                {
                    types.add(a.getType());
                    for(Discipline d: service.getDisciplineRepo().getEntities())
                    {
                        if(a.getDisciplineId()==d.getId())
                            disciplines.add(d.getName());
                    }
                    for(Teacher t : service.getTeacherRepo().getEntities())
                    {
                        if(a.getTeacherId()==t.getId())
                            teachers.add(t.getName());
                    }
                }
            }
            for(Room r: service.getRoomRepo().getEntities())
            {
                if(r.getId()==s.getRoomId())
                    rooms.add(r.getName());
            }
        }

        ObservableList<String> obsDays = FXCollections.observableArrayList(days);
        this.TTdayListView.setItems(obsDays);
        ObservableList<String> obsInterv = FXCollections.observableArrayList(intervals);
        this.TTintervalListView.setItems(obsInterv);
        ObservableList<String> obsDisc = FXCollections.observableArrayList(disciplines);
        this.TTsubjectListView.setItems(obsDisc);
        ObservableList<String> obsTypes = FXCollections.observableArrayList(types);
        this.TTtypeListView.setItems(obsTypes);
        ObservableList<String> obsTeachers = FXCollections.observableArrayList(teachers);
        this.TTteacherListView.setItems(obsTeachers);
        ObservableList<String> obsRooms = FXCollections.observableArrayList(rooms);
        this.TTroomListView.setItems(obsRooms);

        groupLabel.setText(subgroup);

    }


    @FXML
    public void initialize() {
        // populate the table
        ArrayList<Teacher> teachers = this.service.getTeacherRepo().getEntities();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
        idTeacher.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTeacher.setCellValueFactory(new PropertyValueFactory<>("name"));
        rankTeacher.setCellValueFactory(new PropertyValueFactory<>("rank"));
        this.teacherTableView.setItems(obsTeachers);

        ArrayList<Discipline> disciplines = this.service.getDisciplineRepo().getEntities();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);
        idDiscipline.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameDiscipline.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.disciplineTableView.setItems(obsDisciplines);

        ArrayList<Activity> activities = this.service.getActivityRepo().getEntities();
        ObservableList<Activity> obsActivities = FXCollections.observableArrayList(activities);
        this.activityListView.setItems(obsActivities);
        this.activitiesListView.setItems(obsActivities);

        ArrayList<Room> rooms = this.service.getRoomRepo().getEntities();
        ObservableList<Room> obsRooms = FXCollections.observableArrayList(rooms);
        this.roomListView.setItems(obsRooms);


        Timeslot ts1 = new Timeslot("Monday", 8, 10);
        Timeslot ts2 = new Timeslot("Monday", 10, 12);
        Timeslot ts3 = new Timeslot("Monday", 12, 14);
        Timeslot ts4 = new Timeslot("Monday", 14, 16);
        Timeslot ts5 = new Timeslot("Monday", 16, 18);
        Timeslot ts6 = new Timeslot("Monday", 18, 20);
        Timeslot ts7 = new Timeslot("Tuesday", 8, 10);
        Timeslot ts8 = new Timeslot("Tuesday", 10, 12);
        Timeslot ts9 = new Timeslot("Tuesday", 12, 14);
        Timeslot ts10 = new Timeslot("Tuesday", 14, 16);
        Timeslot ts11 = new Timeslot("Tuesday", 16, 18);
        Timeslot ts12 = new Timeslot("Tuesday", 18, 20);
        Timeslot ts13 = new Timeslot("Wednesday", 8, 10);
        Timeslot ts14 = new Timeslot("Wednesday", 10, 12);
        Timeslot ts15 = new Timeslot("Wednesday", 12, 14);
        Timeslot ts16 = new Timeslot("Wednesday", 14, 16);
        Timeslot ts17 = new Timeslot("Wednesday", 16, 18);
        Timeslot ts18 = new Timeslot("Wednesday", 18, 20);
        Timeslot ts19 = new Timeslot("Thursday", 8, 10);
        Timeslot ts20 = new Timeslot("Thursday", 10, 12);
        Timeslot ts21 = new Timeslot("Thursday", 12, 14);
        Timeslot ts22 = new Timeslot("Thursday", 14, 16);
        Timeslot ts23 = new Timeslot("Thursday", 16, 18);
        Timeslot ts24 = new Timeslot("Thursday", 18, 20);
        Timeslot ts25 = new Timeslot("Friday", 8, 10);
        Timeslot ts26 = new Timeslot("Friday", 10, 12);
        Timeslot ts27 = new Timeslot("Friday", 12, 14);
        Timeslot ts28 = new Timeslot("Friday", 14, 16);
        Timeslot ts29 = new Timeslot("Friday", 16, 18);
        Timeslot ts30 = new Timeslot("Friday", 18, 20);

        ArrayList<Timeslot> timeslots = new ArrayList<>();
        timeslots.add(ts1);
        timeslots.add(ts2);
        timeslots.add(ts3);
        timeslots.add(ts4);
        timeslots.add(ts5);
        timeslots.add(ts6);
        timeslots.add(ts7);
        timeslots.add(ts8);
        timeslots.add(ts9);
        timeslots.add(ts10);
        timeslots.add(ts11);
        timeslots.add(ts12);
        timeslots.add(ts13);
        timeslots.add(ts14);
        timeslots.add(ts15);
        timeslots.add(ts16);
        timeslots.add(ts17);
        timeslots.add(ts18);
        timeslots.add(ts19);
        timeslots.add(ts20);
        timeslots.add(ts21);
        timeslots.add(ts22);
        timeslots.add(ts23);
        timeslots.add(ts24);
        timeslots.add(ts25);
        timeslots.add(ts26);
        timeslots.add(ts27);
        timeslots.add(ts28);
        timeslots.add(ts29);
        timeslots.add(ts30);
        ObservableList<Timeslot> obsTimeslot = FXCollections.observableArrayList(timeslots);
        day.setCellValueFactory(new PropertyValueFactory<>(day.getText()));
        start.setCellValueFactory(new PropertyValueFactory<>(start.getText()));
        end.setCellValueFactory(new PropertyValueFactory<>(end.getText()));
        this.timeslotTableView.setItems(obsTimeslot);


        ArrayList<Subgroup> subgroups = new ArrayList<>();

        for (int i = 0; i < this.service.getSpecialisationRepo().getEntities().size(); i++) {
            {
                for (int j = 0; j < this.service.getSpecialisationRepo().getEntities().get(i).getGroups().size(); j++) {
                    for (int k = 0; k < this.service.getSpecialisationRepo().getEntities().get(i).getGroups().get(j).getSubgroups().size(); k++) {
                        subgroups.add(this.service.getSpecialisationRepo().getEntities().get(i).getGroups().get(j).getSubgroups().get(k));
                    }
                }

            }
        }
        for (int i = 0; i < subgroups.size(); i++)
            System.out.println(subgroups.get(i));

        ObservableList<Subgroup> obsSubgroups = FXCollections.observableArrayList(subgroups);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.subgroupTableView.setItems(obsSubgroups);

        ArrayList<Subject> subjects = service.getSubjectRepo().getEntities();
        ObservableList<Subject> obsSubjects = FXCollections.observableArrayList(subjects);
        this.associationsListView.setItems(obsSubjects);

        ArrayList<Subgroup> allSubgroups = new ArrayList<>();
        ArrayList<Specialisation> specialisations = service.getSpecialisationRepo().getEntities();
        for(Specialisation s: specialisations)
        {
            ArrayList<Group> groups = s.getGroups();
            for(Group g: groups)
            {
                ArrayList<Subgroup> subgroups1 = g.getSubgroups();
                for(Subgroup sg: subgroups1)
                    allSubgroups.add(sg);
            }
        }
        ObservableList<Subgroup> obsSubgroups1 = FXCollections.observableArrayList(allSubgroups);
        this.groupListView.setItems(obsSubgroups1);
    }

    @FXML
    void addTeacherButtonHandler(Event event) {
        int id = Integer.parseInt(this.idTeacherText.getText());
        String name = this.nameTeacherText.getText();
        String rank = this.rankTeacherText.getText();
        Teacher teacher = new Teacher(id, name, rank);
        Boolean ok = service.addTeacher(teacher);
        if (ok)
            System.out.println("The teacher was added");
        else
            System.out.println("Error");

        ArrayList<Teacher> teachers = this.service.getTeacherRepo().getEntities();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
        this.teacherTableView.setItems(obsTeachers);

    }

    @FXML
    void deleteTeacherButtonHandler(Event event) {
        int id = Integer.parseInt(this.oldIdTeacherText.getText());
        Boolean ok = service.deleteTeacher(id);
        if (ok)
            System.out.println("The teacher was deleted");
        else
            System.out.println("Error");

        ArrayList<Teacher> teachers = this.service.getTeacherRepo().getEntities();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
        this.teacherTableView.setItems(obsTeachers);
    }

    @FXML
    void updateTeacherButtonHandler(Event event) {
        int oldId = Integer.parseInt(this.oldIdTeacherText.getText());
        int id = Integer.parseInt(this.idTeacherText.getText());
        String name = this.nameTeacherText.getText();
        String rank = this.rankTeacherText.getText();
        Teacher teacher = new Teacher(id, name, rank);
        Boolean ok = service.updateTeacher(oldId, teacher);
        if (ok)
            System.out.println("The teacher was updated");
        else
            System.out.println("Error");

        ArrayList<Teacher> teachers = this.service.getTeacherRepo().getEntities();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
        this.teacherTableView.setItems(obsTeachers);

    }

    @FXML
    void addDisciplineButtonHandler(Event event) {
        int id = Integer.parseInt(this.idDisciplineText.getText());
        String name = this.nameDisciplineText.getText();
        Discipline discipline = new Discipline(id, name);
        Boolean ok = service.addDiscipline(discipline);
        if (ok)
            System.out.println("The discipline was added");
        else
            System.out.println("Error");

        ArrayList<Discipline> disciplines = this.service.getDisciplineRepo().getEntities();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);
        this.disciplineTableView.setItems(obsDisciplines);

    }

    @FXML
    void deleteDisciplineButtonHandler(Event event) {
        int id = Integer.parseInt(this.oldIdDisciplineText.getText());
        Boolean ok = service.deleteDiscipline(id);
        if (ok)
            System.out.println("The discipline was deleted");
        else
            System.out.println("Error");

        ArrayList<Discipline> disciplines = this.service.getDisciplineRepo().getEntities();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);
        this.disciplineTableView.setItems(obsDisciplines);

    }

    @FXML
    void updateDisciplineButtonHandler(Event event) {
        int oldId = Integer.parseInt(this.oldIdDisciplineText.getText());
        int id = Integer.parseInt(this.idDisciplineText.getText());
        String name = this.nameDisciplineText.getText();
        Discipline discipline = new Discipline(id, name);
        Boolean ok = service.updateDiscipline(oldId, discipline);
        if (ok)
            System.out.println("The discipline was updated");
        else
            System.out.println("Error");

        ArrayList<Discipline> disciplines = this.service.getDisciplineRepo().getEntities();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);
        this.disciplineTableView.setItems(obsDisciplines);

    }

    @FXML
    void associateButtonHandler(Event event) {

        int id = Integer.parseInt(this.idSubjectText.getText());
        Timeslot timeslot = (Timeslot) timeslotTableView.getSelectionModel().getSelectedItem();
        Subgroup subgroup = (Subgroup) subgroupTableView.getSelectionModel().getSelectedItem();
        Activity activity = (Activity) activityListView.getSelectionModel().getSelectedItem();
        int activityId = activity.getId();
        Room room = (Room) roomListView.getSelectionModel().getSelectedItem();
        int roomId = room.getId();
        Subject subject = new Subject(id, timeslot, subgroup, activityId, roomId);
        service.addSubject(subject);
        ArrayList<Subject> subjects = service.getSubjectRepo().getEntities();
        ObservableList<Subject> obsSubjects = FXCollections.observableArrayList(subjects);
        this.associationsListView.setItems(obsSubjects);

    }

    @FXML
    void sortActivitiesButtonHandler(ActionEvent event) {

        int roomId = Integer.parseInt(roomIdTextField.getText());
        List<Subject> subjects =
                service.getSubjectRepo().getEntities().stream()
                        .filter(subject -> subject.getRoomId() == roomId)
                        .sorted((s1, s2) -> s1.getTimeslot().compareTo(s2.getTimeslot()))
                        .collect(Collectors.toList());

        ObservableList<Entity> obs = FXCollections.observableArrayList(subjects);
        this.streamsListView.setItems(obs);


    }

    @FXML
    void sortTeachersButtonHandler(ActionEvent event) {
        String rank = rankTextField.getText();
        List<Teacher> teachers =
                service.getTeacherRepo().getEntities().stream()
                        .filter(st -> st.getRank().equals(rank))
                        .sorted((st1, st2) -> st1.getName().compareTo(st2.getName()))
                        .collect(Collectors.toList());

        ObservableList<Entity> obs = FXCollections.observableArrayList(teachers);
        this.streamsListView.setItems(obs);
    }

    @FXML
    void timetableButtonHandler(ActionEvent event) {
        String formation = formationTextField.getText();
        List<Subject> subjects =
                service.getSubjectRepo().getEntities().stream()
                        .filter(subject -> subject.getSubgroup().getName().equals(formation))
                        .sorted((sj1, sj2) -> sj1.getTimeslot().compareTo(sj2.getTimeslot()))
                        .collect(Collectors.toList());
        ObservableList<Entity> obs = FXCollections.observableArrayList(subjects);
        this.streamsListView.setItems(obs);
    }

    @FXML
    void addActivityButtonHandler(ActionEvent event) {
        Teacher t = (Teacher) teacherTableView.getSelectionModel().getSelectedItem();
        Discipline d = (Discipline) disciplineTableView.getSelectionModel().getSelectedItem();
        int id = Integer.parseInt(activityIdTextField.getText());
        String type = typeTextField.getText();
        Activity a = new Activity(id,type,d.getId(),t.getId());
        service.addActivity(a);


        ArrayList<Activity> activities = this.service.getActivityRepo().getEntities();
        ObservableList<Activity> obs = FXCollections.observableArrayList(activities);
        this.activitiesListView.setItems(obs);
        this.activityListView.setItems(obs);


    }


}