package practical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Acep / D.Tsogtbayar
 */
public class Main extends Application {

    static class DB {

        public final static String host = "127.0.0.1";
        public final static String db = "tsogtbayar_practical";
        public final static String user = "root";
        public final static String pass = "";

        private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        private final static String DATABASE_URL = "jdbc:mysql://" + host + "/" + db + "?useUnicode=yes&characterEncoding=UTF-8";

        private Connection connection;

        private DB() {
            connection = null;

            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, user, pass);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        public ResultSet select(String query) {
            ResultSet result = null;
            try {
                PreparedStatement stmnt = connection.prepareStatement(query);
                result = stmnt.executeQuery();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
        }

        public boolean insert(String query) {
            try {
                PreparedStatement stmnt = connection.prepareStatement(query);
                return stmnt.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }

        public boolean delete(String query) {
            try {
                PreparedStatement stmnt = connection.prepareStatement(query);
                return stmnt.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }

        public boolean update(String query) {
            try {
                PreparedStatement stmnt = connection.prepareStatement(query);
                return stmnt.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public class Person {

        private String id,
                undes,
                lastname,
                firstname,
                gender,
                birthday,
                phone,
                address,
                registrationNum,
                identityNum,
                career,
                education,
                married,
                highschool,
                university,
                language,
                computerKnowledge,
                img;

        public Person() {
            this.id = "";
            this.undes = "";
            this.lastname = "";
            this.firstname = "";
            this.gender = "";
            this.birthday = "";
            this.phone = "";
            this.address = "";
            this.registrationNum = "";
            this.identityNum = "";
            this.career = "";
            this.education = "";
            this.married = "";
            this.highschool = "";
            this.university = "";
            this.language = "";
            this.computerKnowledge = "";
            this.img = "";
        }

        public Person(String id, String undes, String lastname, String firstname, String gender, String birthday, String phone, String address, String registrationNum, String identityNum, String career, String education, String married, String highschool, String university, String language, String computerKnowledge, String img) {
            this.id = id;
            this.undes = undes;
            this.lastname = lastname;
            this.firstname = firstname;
            this.gender = gender;
            this.birthday = birthday;
            this.phone = phone;
            this.address = address;
            this.registrationNum = registrationNum;
            this.identityNum = identityNum;
            this.career = career;
            this.education = education;
            this.married = married;
            this.highschool = highschool;
            this.university = university;
            this.language = language;
            this.computerKnowledge = computerKnowledge;
            this.img = img;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUndes() {
            return undes;
        }

        public void setUndes(String undes) {
            this.undes = undes;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRegistrationNum() {
            return registrationNum;
        }

        public void setRegistrationNum(String registrationNum) {
            this.registrationNum = registrationNum;
        }

        public String getIdentityNum() {
            return identityNum;
        }

        public void setIdentityNum(String identityNum) {
            this.identityNum = identityNum;
        }

        public String getCareer() {
            return career;
        }

        public void setCareer(String career) {
            this.career = career;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getMarried() {
            return married;
        }

        public void setMarried(String married) {
            this.married = married;
        }

        public String getHighschool() {
            return highschool;
        }

        public void setHighschool(String highschool) {
            this.highschool = highschool;
        }

        public String getUniversity() {
            return university;
        }

        public void setUniversity(String university) {
            this.university = university;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getComputerKnowledge() {
            return computerKnowledge;
        }

        public void setComputerKnowledge(String computerKnowledge) {
            this.computerKnowledge = computerKnowledge;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

    }
    /**
     * id undes lastname firstname gender birthday phone address registrationNum
     * identityNum career education married highschool university language
     * computerKnowledge;
     */

    private Scene loginScene, indexScene, editScene, addScene, viewScene;
    private DB db;
    private Stage stage;

    private ObservableList<Person> tableItems;
    private TableView tableView;

    private ObservableList<String> educationList = FXCollections.observableArrayList();
    private ObservableList<String> marriedList = FXCollections.observableArrayList();
    private ObservableList<String> comList = FXCollections.observableArrayList();
    private ObservableList<String> searchTypeList = FXCollections.observableArrayList();

    private Stage permissionStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        db = new DB();

        educationList.add("Дээд");
        educationList.add("Дунд");

        marriedList.add("Гэрлэсэн");
        marriedList.add("Гэрлээгүй");
        marriedList.add("Салсан");

        comList.add("Муу");
        comList.add("Дунд");
        comList.add("Сайн");
        comList.add("Маш Сайн");
        
        searchTypeList.add("ID");
        searchTypeList.add("Овог");
        searchTypeList.add("Нэр");

        permissionStage = new Stage();

        loginScene();
        indexScene();
        editScene();
        addScene();
        permissionStage(permissionStage);

        stage.setScene(loginScene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setTitle("Practical Exam");
        stage.show();
    }

    private void viewScene() {
        BorderPane border = new BorderPane();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Person person = (Person) tableView.getSelectionModel().getSelectedItem();
        loadPermissions();

        ImageView img = null;
        try {
            img = new ImageView(new Image(new FileInputStream(person.getImg())));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        img.setPreserveRatio(true);
        img.setFitWidth(400);
        img.setFitHeight(400);
        img.setVisible(imgc.isSelected());
        grid.add(img, 1, 1);
        
        Label id = new Label("Ажилтны ID: " + person.getId());
        id.setVisible(idc.isSelected());
        grid.add(id, 1, 2);
        
        Label undes = new Label("Яс үндэс: " + person.getUndes());
        undes.setVisible(undesc.isSelected());
        grid.add(undes, 1, 3);
        
        Label lastname = new Label("Овог: " + person.getLastname());
        lastname.setVisible(lastnamec.isSelected());
        grid.add(lastname, 1, 4);
        
        Label firstname = new Label("Нэр: " + person.getFirstname());
        firstname.setVisible(firstnamec.isSelected());
        grid.add(firstname, 1, 5);
        
        Label gender = new Label("Хүйс: " + person.getGender());
        gender.setVisible(genderc.isSelected());
        grid.add(gender, 1, 6);
        
        Label birthday = new Label("Төрсөн огноо: " + person.getBirthday());
        birthday.setVisible(birthdayc.isSelected());
        grid.add(birthday, 1, 7);
        
        Label phone = new Label("Утас: " + person.getPhone());
        phone.setVisible(phonec.isSelected());
        grid.add(phone, 1, 8);
        
        Label address = new Label("Гэрийн хаяг: " + person.getAddress());
        address.setVisible(addressc.isSelected());
        grid.add(address, 1, 9);
        
        Label reg = new Label("РД: " + person.getRegistrationNum());
        reg.setVisible(regc.isSelected());
        grid.add(reg, 1, 10);
        
        Label identity = new Label("Иргэний үнэмлэхний №: " + person.getIdentityNum());
        identity.setVisible(identityc.isSelected());
        grid.add(identity, 2, 2);
        
        Label career = new Label("Мэргэжил: " + person.getCareer());
        career.setVisible(careerc.isSelected());
        grid.add(career, 2, 3);
        
        Label education = new Label("Боловсрол: " + person.getEducation());
        education.setVisible(educ.isSelected());
        grid.add(education, 2, 4);
        
        Label married = new Label("Гэрлэсэн эсэх: " + person.getMarried());
        married.setVisible(marriedc.isSelected());
        grid.add(married, 2, 5);
        
        Label high = new Label("10 жил: " + person.getHighschool());
        high.setVisible(highc.isSelected());
        grid.add(high, 2, 6);
        
        Label uni = new Label("Дээд сургууль: " + person.getUniversity());
        uni.setVisible(unic.isSelected());
        grid.add(uni, 2, 7);
        
        Label lang = new Label("Гадаад хэлний мэдлэг: " + person.getLanguage());
        lang.setVisible(langc.isSelected());
        grid.add(lang, 2, 8);
        
        Label com = new Label("Компьютерийн мэдлэг: " + person.getComputerKnowledge());
        com.setVisible(comc.isSelected());
        grid.add(com, 2, 9);

        FlowPane footer = new FlowPane();
        Button back = new Button("Буцах");
        back.setOnAction((event) -> {
            switchToScene(indexScene);
        });
        footer.setPadding(new Insets(10, 10, 10, 10));
        footer.getChildren().add(back);
        border.setBottom(footer);
        border.setCenter(grid);
        viewScene = new Scene(border);
    }

    private int person_id;
    private CheckBox idc;
    private CheckBox imgc;
    private CheckBox undesc;
    private CheckBox lastnamec;
    private CheckBox firstnamec;
    private CheckBox genderc;
    private CheckBox birthdayc;
    private CheckBox phonec;
    private CheckBox addressc;
    private CheckBox regc;
    private CheckBox identityc;
    private CheckBox careerc;
    private CheckBox educ;
    private CheckBox marriedc;
    private CheckBox highc;
    private CheckBox unic;
    private CheckBox langc;
    private CheckBox comc;

    private void permissionStage(Stage stage) {
        BorderPane border = new BorderPane();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        border.setCenter(grid);
        Scene scene = new Scene(border);

        Label title = new Label("Ажилтны мэдээллийг харах эрх тавьж өгөх хэсэг");
        title.setFont(new Font("Berlin Sans FB", 18));
        title.setAlignment(Pos.CENTER);
        title.setPadding(new Insets(15));
        border.setTop(title);
        idc = new CheckBox("Ажилтны ID");
        grid.add(idc, 1, 1);
        imgc = new CheckBox("Зураг");
        grid.add(imgc, 1, 2);
        undesc = new CheckBox("Яс үндэс");
        grid.add(undesc, 1, 3);
        lastnamec = new CheckBox("Овог");
        grid.add(lastnamec, 1, 4);
        firstnamec = new CheckBox("Нэр");
        grid.add(firstnamec, 1, 5);
        genderc = new CheckBox("Хүйс");
        grid.add(genderc, 1, 6);
        birthdayc = new CheckBox("Төрсөн огноо");
        grid.add(birthdayc, 1, 7);
        phonec = new CheckBox("Утас");
        grid.add(phonec, 1, 8);
        addressc = new CheckBox("Гэрийн хаяг");
        grid.add(addressc, 1, 9);
        regc = new CheckBox("Регистрийн дугаар");
        grid.add(regc, 2, 1);
        identityc = new CheckBox("Иргэний үнэмлэхний дугаар");
        grid.add(identityc, 2, 2);
        careerc = new CheckBox("Мэргэжил");
        grid.add(careerc, 2, 3);
        educ = new CheckBox("Боловсрол");
        grid.add(educ, 2, 4);
        marriedc = new CheckBox("Гэрлэсэн эсэх");
        grid.add(marriedc, 2, 5);
        highc = new CheckBox("10 жилийн сургууль");
        grid.add(highc, 2, 6);
        unic = new CheckBox("Дээд сургууль");
        grid.add(unic, 2, 7);
        langc = new CheckBox("Гадаад хэлний мэдлэг");
        grid.add(langc, 2, 8);
        comc = new CheckBox("Компьютерийн мэдлэг");
        grid.add(comc, 2, 9);
        
        Button saveButton = new Button("Хадгалах");
        saveButton.setOnAction((event)-> {
            savePermissions();
            permissionStage.close();
        });
        FlowPane footer = new FlowPane(saveButton);
        footer.setPadding(new Insets(10, 10, 10, 10));
        
        border.setBottom(footer);
        
        stage.setScene(scene);
    }

    private void loadPermissions() {
        ResultSet result = db.select("select * from permission where person_id = "+((Person) tableView.getSelectionModel().getSelectedItem()).getId() + " limit 1");
        person_id = Integer.parseInt(((Person) tableView.getSelectionModel().getSelectedItem()).getId());
        try {
            while (result.last()) {
                idc.setSelected(result.getBoolean("id"));
                undesc.setSelected(result.getBoolean("undes"));
                lastnamec.setSelected(result.getBoolean("lastname"));
                firstnamec.setSelected(result.getBoolean("firstname"));
                genderc.setSelected(result.getBoolean("gender"));
                birthdayc.setSelected(result.getBoolean("birthday"));
                phonec.setSelected(result.getBoolean("phone"));
                addressc.setSelected(result.getBoolean("address"));
                regc.setSelected(result.getBoolean("registrationNum"));
                identityc.setSelected(result.getBoolean("identityNum"));
                careerc.setSelected(result.getBoolean("career"));
                educ.setSelected(result.getBoolean("education"));
                marriedc.setSelected(result.getBoolean("married"));
                highc.setSelected(result.getBoolean("highschool"));
                unic.setSelected(result.getBoolean("university"));
                langc.setSelected(result.getBoolean("language"));
                comc.setSelected(result.getBoolean("computerKnowledge"));
                imgc.setSelected(result.getBoolean("img"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void savePermissions() {
        try {
            PreparedStatement ps = db.connection.prepareStatement("update permission set "
                    + "id = ?, "
                    + "undes = ?, "
                    + "lastname = ?, "
                    + "firstname = ?, "
                    + "gender = ?, "
                    + "birthday = ?, "
                    + "phone = ?, "
                    + "address = ?, "
                    + "registrationNum = ?, "
                    + "identityNum = ?, "
                    + "career = ?, "
                    + "education = ?, "
                    + "married = ?, "
                    + "highschool = ?, "
                    + "university = ?, "
                    + "language = ?, "
                    + "computerKnowledge = ? ,"
                    + "img = ? "
                    + "where person_id = ?");
            ps.setBoolean(1, idc.isSelected());
            ps.setBoolean(2, undesc.isSelected());
            ps.setBoolean(3, lastnamec.isSelected());
            ps.setBoolean(4, firstnamec.isSelected());
            ps.setBoolean(5, genderc.isSelected());
            ps.setBoolean(6, birthdayc.isSelected());
            ps.setBoolean(7, phonec.isSelected());
            ps.setBoolean(8, addressc.isSelected());
            ps.setBoolean(9, regc.isSelected());
            ps.setBoolean(10, identityc.isSelected());
            ps.setBoolean(11, careerc.isSelected());
            ps.setBoolean(12, educ.isSelected());
            ps.setBoolean(13, marriedc.isSelected());
            ps.setBoolean(14, highc.isSelected());
            ps.setBoolean(15, unic.isSelected());
            ps.setBoolean(16, langc.isSelected());
            ps.setBoolean(17, comc.isSelected());
            ps.setBoolean(18, imgc.isSelected());
            ps.setInt(19, person_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    private ObservableList<Person> getPersons() {
        ObservableList<Person> returnList = FXCollections.observableArrayList();
        ResultSet result = db.select("select * from person");
        try {
            while (result.next()) {
                Person person = new Person();
                person.setId(result.getString("id"));
                person.setUndes(result.getString("undes"));
                person.setLastname(result.getString("lastname"));
                person.setFirstname(result.getString("firstname"));
                person.setGender(result.getString("gender"));
                person.setBirthday(result.getString("birthday"));
                person.setPhone(result.getString("phone"));
                person.setAddress(result.getString("address"));
                person.setRegistrationNum(result.getString("registrationNum"));
                person.setIdentityNum(result.getString("identityNum"));
                person.setCareer(result.getString("career"));
                person.setEducation(result.getString("education"));
                person.setMarried(result.getString("married"));
                person.setHighschool(result.getString("highschool"));
                person.setUniversity(result.getString("university"));
                person.setLanguage(result.getString("language"));
                person.setComputerKnowledge(result.getString("computerKnowledge"));
                person.setImg(result.getString("img"));
                returnList.add(person);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return returnList;
    }
    
    private ObservableList<Person> getPersonsBy(String searchColumn, String keyword) {
        ObservableList<Person> returnList = FXCollections.observableArrayList();
        ResultSet result = db.select("select * from person where "+searchColumn+" like '%"+keyword+"%'");
        try {
            while (result.next()) {
                Person person = new Person();
                person.setId(result.getString("id"));
                person.setUndes(result.getString("undes"));
                person.setLastname(result.getString("lastname"));
                person.setFirstname(result.getString("firstname"));
                person.setGender(result.getString("gender"));
                person.setBirthday(result.getString("birthday"));
                person.setPhone(result.getString("phone"));
                person.setAddress(result.getString("address"));
                person.setRegistrationNum(result.getString("registrationNum"));
                person.setIdentityNum(result.getString("identityNum"));
                person.setCareer(result.getString("career"));
                person.setEducation(result.getString("education"));
                person.setMarried(result.getString("married"));
                person.setHighschool(result.getString("highschool"));
                person.setUniversity(result.getString("university"));
                person.setLanguage(result.getString("language"));
                person.setComputerKnowledge(result.getString("computerKnowledge"));
                person.setImg(result.getString("img"));
                returnList.add(person);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return returnList;
    }

    private boolean deletePerson(Person person) {
        try {
            PreparedStatement st = db.connection.prepareStatement("delete from person where id = ?");
            PreparedStatement st2 = db.connection.prepareStatement("delete from permission where person_id = ?");
            st2.setInt(1, Integer.parseInt(person.getId()));
            st.setInt(1, Integer.parseInt(person.getId()));
            st2.executeUpdate();
            st.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (NumberFormatException ex1) {
            return false;
        }
    }
    
    private void indexScene() {
        int bwidth = 100;
        int bheight = 30;

        int scrollw = 600;
        int scrollh = 400;
        
        MenuItem viewItem = new MenuItem("Харах");
        viewItem.setOnAction((event) -> {
            if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                viewScene();
                switchToScene(viewScene);
            } else {
                JOptionPane.showMessageDialog(null, "Та хүснэгтээс мэдээллээ сонгоно уу?");
            }
        });
        MenuItem addItem = new MenuItem("Нэмэх");
        addItem.setOnAction((event) -> {
            switchToScene(addScene);
        });
        MenuItem editItem = new MenuItem("Засах");
        editItem.setOnAction((event) -> {
            if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                loadEditing();
                switchToScene(editScene);
            } else {
                JOptionPane.showMessageDialog(null, "Та хүснэгтээс мэдээллээ сонгоно уу?");
            }
        });
        MenuItem deleteItem = new MenuItem("Устгах");
        deleteItem.setOnAction((event) -> {
            if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                int confirm = JOptionPane.showConfirmDialog(null, "Та устгахдаа итгэлтэй байна уу?", "Устгах", JOptionPane.YES_NO_OPTION);
                if (confirm < JOptionPane.YES_OPTION) {
                    Person person = (Person) tableView.getSelectionModel().getSelectedItem();
                    if (deletePerson(person)) {
                        tableItems.remove(tableView.getSelectionModel().getSelectedItem());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Та хүснэгтээс мэдээллээ сонгоно уу?");
            }
        });
        MenuItem permissionItem = new MenuItem("Эрхийн тохиргоо");
        permissionItem.setOnAction((event) -> {
            if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                loadPermissions();
                permissionStage.show();
            } else {
                JOptionPane.showMessageDialog(null, "Та хүснэгтээс мэдээллээ сонгоно уу?");
            }
        });
        SeparatorMenuItem sepItem = new SeparatorMenuItem();
        MenuItem exitItem = new MenuItem("Гарах");
        exitItem.setOnAction((event) -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Та гарахдаа итгэлтэй байна уу?", "Гарах", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(1);
            }
        });
        Menu indexMenu = new Menu("Үндсэн цэс");
        indexMenu.getItems().addAll(viewItem, addItem, editItem, deleteItem, permissionItem, sepItem, exitItem);
        Menu helpMenu = new Menu("Тусламж");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(indexMenu);
        menuBar.getMenus().add(helpMenu);

        Label centerLabel = new Label("Мэдээлэл");
        centerLabel.setFont(new Font("Berlin Sans FB", 16));
        tableItems = FXCollections.observableArrayList();
        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn undesCol = new TableColumn("Яс Үндэс");
        undesCol.setCellValueFactory(new PropertyValueFactory<>("undes"));
        TableColumn lastnameCol = new TableColumn("Овог");
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        TableColumn firstnameCol = new TableColumn("Нэр");
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        TableColumn genderCol = new TableColumn("Хүйс");
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableColumn birthdayCol = new TableColumn("Төрсөн өдөр");
        birthdayCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        TableColumn phoneCol = new TableColumn("Утас");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn addressCol = new TableColumn("Хаяг");
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn regCol = new TableColumn("Регистрийн дугаар");
        regCol.setCellValueFactory(new PropertyValueFactory<>("registrationNum"));
        TableColumn identityCol = new TableColumn("Иргэний үнэмлэхний дугаар");
        identityCol.setCellValueFactory(new PropertyValueFactory<>("identityNum"));
        TableColumn careerCol = new TableColumn("Мэргэжил");
        careerCol.setCellValueFactory(new PropertyValueFactory<>("career"));
        TableColumn eduCol = new TableColumn("Боловсрол");
        eduCol.setCellValueFactory(new PropertyValueFactory<>("education"));
        TableColumn marriedCol = new TableColumn("Гэрэлсэн эсэх");
        marriedCol.setCellValueFactory(new PropertyValueFactory<>("married"));
        TableColumn highCol = new TableColumn("Төгссөн дунд сургууль");
        highCol.setCellValueFactory(new PropertyValueFactory<>("highschool"));
        TableColumn uniCol = new TableColumn("Төгссөн дээд сургууль");
        uniCol.setCellValueFactory(new PropertyValueFactory<>("university"));
        TableColumn langCol = new TableColumn("Хэлний мэдлэг");
        langCol.setCellValueFactory(new PropertyValueFactory<>("language"));
        TableColumn comCol = new TableColumn("Компьютерийн мэдлэг");
        comCol.setCellValueFactory(new PropertyValueFactory<>("computerKnowledge"));
        tableView = new TableView(tableItems);
        tableView.getColumns().addAll(
                idCol,
                undesCol,
                lastnameCol,
                firstnameCol,
                genderCol,
                birthdayCol,
                phoneCol,
                addressCol,
                regCol,
                identityCol,
                careerCol,
                eduCol,
                marriedCol,
                highCol,
                uniCol,
                langCol,
                comCol
        );
        tableView.setMaxSize(scrollw, scrollh);
        tableView.setPrefSize(scrollw, scrollh);

        Label rightLabel = new Label("Удирдлага");
        rightLabel.setFont(new Font("Berlin Sans FB", 16));
        Button viewButton = new Button("Харах", new ImageView(new Image("practical/resources/view.png")));
        viewButton.setPrefSize(bwidth, bheight);
        viewButton.setOnAction((event) -> {
            if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                viewScene();
                switchToScene(viewScene);
            } else {
                JOptionPane.showMessageDialog(null, "Та хүснэгтээс мэдээллээ сонгоно уу?");
            }
        });
        Button addButton = new Button("Нэмэх", new ImageView(new Image("practical/resources/add.png")));
        addButton.setOnAction((event) -> switchToScene(addScene));
        addButton.setPrefSize(bwidth, bheight);
        Button editButton = new Button("Засах", new ImageView(new Image("practical/resources/edit.png")));
        editButton.setOnAction((event) -> {
            if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                loadEditing();
                switchToScene(editScene);
            } else {
                JOptionPane.showMessageDialog(null, "Та хүснэгтээс мэдээллээ сонгоно уу?");
            }
        });
        editButton.setPrefSize(bwidth, bheight);
        Button deleteButton = new Button("Устгах", new ImageView(new Image("practical/resources/delete.png")));
        deleteButton.setPrefSize(bwidth, bheight);
        deleteButton.setOnAction((event) -> {
            if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                int confirm = JOptionPane.showConfirmDialog(null, "Та устгахдаа итгэлтэй байна уу?", "Устгах", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    Person person = (Person) tableView.getSelectionModel().getSelectedItem();
                    if (deletePerson(person)) {
                        tableItems.remove(tableView.getSelectionModel().getSelectedItem());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Та хүснэгтээс мэдээллээ сонгоно уу?");
            }
        });
        Button permissionButton = new Button("Мэдээлэл", new ImageView(new Image("practical/resources/lock.png")));
        permissionButton.setPrefSize(bwidth, bheight);
        permissionButton.setOnAction((event) -> {
            if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                loadPermissions();
                permissionStage.show();
            } else {
                JOptionPane.showMessageDialog(null, "Та хүснэгтээс мэдээллээ сонгоно уу?");
            }
        });
        Label gap = new Label(" ");
        gap.setMinHeight(100);
        Button exitButton = new Button("Гарах", new ImageView(new Image("practical/resources/exit.png")));
        exitButton.setPrefSize(bwidth, bheight);
        exitButton.setOnAction((event) -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Та гарахдаа итгэлтэй байна уу?", "Гарах", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(1);
            }
        });
        
        Label bottomLabel = new Label("Хайлт");
        bottomLabel.setPadding(new Insets(5, 0, 0, 0));
        bottomLabel.setFont(new Font("Berlin Sans FB", 16));
        int height = 27;
        Label searchLabel = new Label("Хайх үг: ");
        searchLabel.setPrefSize(80, height);
        searchLabel.setFont(new Font("Berlin Sans FB", 14));
        TextField searchField = new TextField();
        searchField.setPrefSize(200, height);
        Label typeLabel = new Label("Хайх төрөл: ");
        typeLabel.setPrefSize(80, height);
        typeLabel.setFont(new Font("Berlin Sans FB", 14));
        ComboBox typeCombo = new ComboBox(searchTypeList);
        typeCombo.setPrefSize(200, height);
        Button searchButton = new Button("Хайх", new ImageView(new Image("practical/resources/search-icon.png")));
        searchButton.setOnAction((event) -> {
            if (searchField.getText().equals("")) {
                tableItems.clear();
                getPersons().stream().forEach((person) -> tableItems.add(person));
            } else if ((searchField.getText().equals("") && typeCombo.getSelectionModel().getSelectedIndex() < 0) || (typeCombo.getSelectionModel().getSelectedIndex() < 0)) {
                tableItems.clear();
                getPersons().stream().forEach((person) -> tableItems.add(person));
            } else if (!searchField.getText().equals("") && typeCombo.getSelectionModel().getSelectedIndex() >= 0) {
                switch (typeCombo.getSelectionModel().getSelectedIndex()) {
                    case 0:
                        tableItems.clear();
                        getPersonsBy("id", searchField.getText()).stream().forEach((person) -> tableItems.add(person));
                        break;
                    case 1:
                        tableItems.clear();
                        getPersonsBy("lastname", searchField.getText()).stream().forEach((person) -> tableItems.add(person));
                        break;
                    case 2:
                        tableItems.clear();
                        getPersonsBy("firstname", searchField.getText()).stream().forEach((person) -> tableItems.add(person));
                        break;
                }
            }
        });
        HBox footer = new HBox(25, searchLabel, searchField, typeLabel, typeCombo, searchButton);
        footer.setAlignment(Pos.CENTER);
        
        VBox centerBox = new VBox(10, centerLabel, tableView);
        centerBox.setPadding(new Insets(15, 15, 15, 15));
        VBox rightBox = new VBox(10, rightLabel, viewButton, addButton, editButton, deleteButton, permissionButton, gap, exitButton);
        rightBox.setPadding(new Insets(15, 15, 15, 15));
        rightBox.setAlignment(Pos.TOP_CENTER);
        rightBox.setStyle("-fx-background-color: #F7F7F7; -fx-border-width: 0px 0px 0px 1px; -fx-border-color: lightgray;");
        VBox bottomBox = new VBox(5, bottomLabel, footer);
        bottomBox.setStyle("-fx-background-color: white; -fx-border-width: 1px 0px 0px 0px; -fx-border-color: lightgray;");
        bottomBox.setPadding(new Insets(7, 15, 7, 15));

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(centerBox);
        root.setRight(rightBox);
        root.setBottom(bottomBox);

        for (Person person : getPersons()) {
            tableItems.add(person);
        }

        indexScene = new Scene(root);
    }

    private int editingId;
    private TextField fileF;
    private TextField undesF;
    private TextField lastnameF;
    private TextField firstnameF;
    private ToggleGroup genderG;
    private RadioButton maleR;
    private RadioButton femaleR;
    private TextField birthdayF;
    private TextField phoneF;
    private TextField addressF;
    private TextField regF;
    private TextField identityF;
    private TextField careerF;
    private ComboBox eduCombo;
    private ComboBox marriedCombo;
    private TextField highF;
    private TextField uniF;
    private TextField langF;
    private ComboBox comCombo;
    private Button chooseButton;
    private Button saveButton;
    private Button backButton;
    
    private void loadEditing() {
        Person editingPerson = (Person) tableView.getSelectionModel().getSelectedItem();
        editingId = Integer.parseInt(editingPerson.getId());
        fileF.setText(editingPerson.getImg());
        undesF.setText(editingPerson.getUndes());
        lastnameF.setText(editingPerson.getLastname());
        firstnameF.setText(editingPerson.getFirstname());
        if (editingPerson.getGender().equals("Эрэгтэй")) {
            maleR.setSelected(true);
            femaleR.setSelected(false);
        } else if (editingPerson.getGender().equals("Эмэгтэй")) {
            femaleR.setSelected(true);
            maleR.setSelected(false);
        }
        birthdayF.setText(editingPerson.getBirthday());
        phoneF.setText(editingPerson.getPhone());
        addressF.setText(editingPerson.getAddress());
        regF.setText(editingPerson.getRegistrationNum());
        identityF.setText(editingPerson.getIdentityNum());
        careerF.setText(editingPerson.getCareer());
        eduCombo.getSelectionModel().select(editingPerson.getEducation());
        marriedCombo.getSelectionModel().select(editingPerson.getMarried());
        highF.setText(editingPerson.getHighschool());
        uniF.setText(editingPerson.getUniversity());
        langF.setText(editingPerson.getLanguage());
        comCombo.getSelectionModel().select(editingPerson.getComputerKnowledge());
    }

    private void editScene() {
        
        GridPane grid = new GridPane();
        grid.setVgap(12);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        ObservableList<Label> labels = FXCollections.observableArrayList();

        int fw = 120;
        int fh = 20;

        fileF = new TextField();
        fileF.setPrefSize(fw, fh);
        grid.add(fileF, 2, 1);
        undesF = new TextField();
        undesF.setPrefSize(fw, fh);
        grid.add(undesF, 2, 2);
        lastnameF = new TextField();
        lastnameF.setPrefSize(fw, fh);
        grid.add(lastnameF, 2, 3);
        firstnameF = new TextField();
        firstnameF.setPrefSize(fw, fh);
        grid.add(firstnameF, 2, 4);
        genderG = new ToggleGroup();
        maleR = new RadioButton("Эрэгтэй");
        maleR.setPrefSize(fw / 2, fh);
        femaleR = new RadioButton("Эмэгтэй");
        femaleR.setPrefSize(fw / 2, fh);
        FlowPane genders = new FlowPane(maleR, femaleR);
        grid.add(genders, 2, 5);
        genderG.getToggles().addAll(maleR, femaleR);
        birthdayF = new TextField();
        birthdayF.setPrefSize(fw, fh);
        grid.add(birthdayF, 2, 6);
        phoneF = new TextField();
        phoneF.setPrefSize(fw, fh);
        grid.add(phoneF, 2, 7);
        addressF = new TextField();
        addressF.setPrefSize(fw, fh);
        grid.add(addressF, 2, 8);
        regF = new TextField();
        regF.setPrefSize(fw, fh);
        grid.add(regF, 2, 9);
        identityF = new TextField();
        identityF.setPrefSize(fw, fh);
        grid.add(identityF, 2, 10);
        careerF = new TextField();
        careerF.setPrefSize(fw, fh);
        grid.add(careerF, 2, 11);
        eduCombo = new ComboBox(educationList);
        eduCombo.setPrefSize(fw, fh);
        eduCombo.getSelectionModel().select(0);
        grid.add(eduCombo, 2, 12);
        marriedCombo = new ComboBox(marriedList);
        marriedCombo.setPrefSize(fw, fh);
        marriedCombo.getSelectionModel().select(0);
        grid.add(marriedCombo, 2, 13);
        highF = new TextField();
        highF.setPrefSize(fw, fh);
        grid.add(highF, 2, 14);
        uniF = new TextField();
        uniF.setPrefSize(fw, fh);
        grid.add(uniF, 2, 15);
        langF = new TextField();
        langF.setPrefSize(fw, fh);
        grid.add(langF, 2, 16);
        comCombo = new ComboBox(comList);
        comCombo.setPrefSize(fw, fh);
        comCombo.getSelectionModel().select(0);
        grid.add(comCombo, 2, 17);
        chooseButton = new Button("Зураг сонгох");
        chooseButton.setPrefSize(fw - fw / 4, fh);
        chooseButton.setOnAction((event) -> {
            FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG File (*.jpg)", "*.jpg");
            FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG File (*.png)", "*.png");
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().addAll(jpgFilter, pngFilter);
            File file = chooser.showOpenDialog(new Stage());
            fileF.setText(file.getAbsolutePath());
        });
        grid.add(chooseButton, 3, 1);
        saveButton = new Button("Хадгалах");
        saveButton.setPrefSize(100, 30);
        saveButton.setOnAction((ActionEvent event) -> {
            // *********************************
            
            String undes = "",
                    lastname = "",
                    firstname = "",
                    gender = "",
                    birthday = "",
                    phone = "",
                    address = "",
                    registrationNum = "",
                    identityNum = "",
                    career = "",
                    education = "",
                    married = "",
                    highschool = "",
                    university = "",
                    language = "",
                    computerKnowledge = "",
                    img = "";
            
            // Your validation here!
            boolean everythingSet = false;
            if (fileF.getText().equals("")) {
                fileF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                img = fileF.getText();
                everythingSet = true;
            }

            if (undesF.getText().equals("")) {
                undesF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                undes = undesF.getText();
                everythingSet = true;
            }

            if (lastnameF.getText().equals("")) {
                lastnameF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                lastname = lastnameF.getText();
                everythingSet = true;
            }

            if (firstnameF.getText().equals("")) {
                firstnameF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                firstname = firstnameF.getText();
                everythingSet = true;
            }

            if (maleR.isSelected() && !femaleR.isSelected()) {
                gender = maleR.getText();
                everythingSet = true;
            } else if (femaleR.isSelected() && !maleR.isSelected()) {
                gender = femaleR.getText();
                everythingSet = true;
            } else if (!maleR.isSelected() || !femaleR.isSelected()) {
                maleR.setStyle("-fx-border-color: red");
                femaleR.setStyle("-fx-border-color: red");
                everythingSet = false;
            }
            
            if (birthdayF.getText().equals("")) {
                birthdayF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                birthday = birthdayF.getText();
                everythingSet = true;
            }

            if (phoneF.getText().equals("")) {
                phoneF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                phone = phoneF.getText();
                everythingSet = true;
            }

            if (addressF.getText().equals("")) {
                addressF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                address = addressF.getText();
                everythingSet = true;
            }

            if (regF.getText().equals("")) {
                regF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                registrationNum = regF.getText();
                everythingSet = true;
            }

            if (identityF.getText().equals("")) {
                identityF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                identityNum = identityF.getText();
                everythingSet = true;
            }

            if (careerF.getText().equals("")) {
                careerF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                career = careerF.getText();
                everythingSet = true;
            }

            if (eduCombo.getSelectionModel().getSelectedIndex() < 0) {
                eduCombo.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                education = eduCombo.getSelectionModel().getSelectedItem().toString();
                everythingSet = true;
            }

            if (marriedCombo.getSelectionModel().getSelectedIndex() < 0) {
                marriedCombo.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                married = marriedCombo.getSelectionModel().getSelectedItem().toString();
                everythingSet = true;
            }

            if (highF.getText().equals("")) {
                highF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                highschool = highF.getText();
                everythingSet = true;
            }

            if (uniF.getText().equals("")) {
                uniF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                university = uniF.getText();
                everythingSet = true;
            }
            
            if (langF.getText().equals("")) {
                langF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                language = langF.getText();
                everythingSet = false;
            }

            if (comCombo.getSelectionModel().getSelectedIndex() < 0) {
                comCombo.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                computerKnowledge = comCombo.getSelectionModel().getSelectedItem().toString();
                everythingSet = true;
            }

            if (everythingSet) {
                Person person = new Person();
                person.setUndes(undes);
                person.setLastname(lastname);
                person.setFirstname(firstname);
                person.setGender(gender);
                person.setBirthday(birthday);
                person.setPhone(phone);
                person.setAddress(address);
                person.setRegistrationNum(registrationNum);
                person.setIdentityNum(identityNum);
                person.setCareer(career);
                person.setEducation(education);
                person.setMarried(married);
                person.setHighschool(highschool);
                person.setUniversity(university);
                person.setLanguage(language);
                person.setComputerKnowledge(computerKnowledge);
                person.setImg(img);
                updatePerson(person, editingId);
                tableItems.clear();
                getPersons().stream().forEach((Person per) -> tableItems.add(per));
                switchToScene(indexScene);
            }
            
            // *********************************
        });
        grid.add(saveButton, 4, 16);
        backButton = new Button("Буцах");
        backButton.setPrefSize(100, 30);
        backButton.setOnAction((event) -> switchToScene(indexScene));
        grid.add(backButton, 4, 17);

        labels.add(new Label("Зураг : "));
        labels.add(new Label("Яс үндэс : "));
        labels.add(new Label("Овог : "));
        labels.add(new Label("Нэр : "));
        labels.add(new Label("Хүйс : "));
        labels.add(new Label("Төрсөн огноо : "));
        labels.add(new Label("Утас : "));
        labels.add(new Label("Гэрийн хаяг : "));
        labels.add(new Label("РД : "));
        labels.add(new Label("Иргэний үнэмлэхний № : "));
        labels.add(new Label("Мэргэжил : "));
        labels.add(new Label("Боловсрол : "));
        labels.add(new Label("Гэрлэсэн эсэх : "));
        labels.add(new Label("Төгссөн /10 жил/ Сургууль : "));
        labels.add(new Label("Төгссөн /Дээд/ Сургууль : "));
        labels.add(new Label("Гадаад хэлний мэдлэг : "));
        labels.add(new Label("Компьютерийн мэдлэг : "));

        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setAlignment(Pos.CENTER_LEFT);
            labels.get(i).setPrefSize(180, 20);
            labels.get(i).setFont(new Font("Berlin Sans FB", 14));
            grid.add(labels.get(i), 1, i + 1);
        }

        editScene = new Scene(grid);
    }

    private void addScene() {
        BorderPane bpane = new BorderPane();

        int careerfw = 200;
        int careerfh = 25;

        ObservableList<Label> labels = FXCollections.observableArrayList();
        labels.add(new Label("Зураг"));
        labels.add(new Label("Яс үндэс : "));
        labels.add(new Label("Овог : "));
        labels.add(new Label("Нэр : "));
        labels.add(new Label("Хүйс : "));
        labels.add(new Label("Төрсөн огноо : "));
        labels.add(new Label("Холбоо барих утас : "));
        labels.add(new Label("Гэрийн хаяг : "));
        labels.add(new Label("РД : "));
        labels.add(new Label("Иргэний үнэмлэхний № : "));
        labels.add(new Label("Мэргэжил : "));
        labels.add(new Label("Боловсрол : "));
        labels.add(new Label("Гэрлэсэн эсэх : "));

        GridPane careerGrid = new GridPane();
        careerGrid.setStyle("-fx-background-color: #FAFCFC; -fx-border-width: 1px; -fx-border-style: solid; -fx-border-color: #D2D5D6;");
        careerGrid.setVgap(10);
        careerGrid.setHgap(5);
        careerGrid.setPadding(new Insets(10, 10, 10, 10));
        Label careerGridLabel = new Label("Мэргэжил");
        careerGridLabel.setFont(new Font("Berlin Sans FB", 16));
        careerGridLabel.setAlignment(Pos.CENTER);
        careerGridLabel.setPrefSize(careerfw, 25);
        careerGrid.add(careerGridLabel, 1, 1);
        GridPane.setColumnSpan(careerGridLabel, 2);

        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setAlignment(Pos.CENTER_LEFT);
            labels.get(i).setPrefSize(180, 20);
            labels.get(i).setFont(new Font("Berlin Sans FB", 14));
            careerGrid.add(labels.get(i), 1, i + 2);
        }

        TextField addfileF = new TextField();
        addfileF.setMinSize(careerfw, careerfh);
        addfileF.setMaxSize(careerfw, careerfh);

        Button addfileB = new Button("Зураг");
        addfileB.setOnAction((event) -> {
            FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG File (*.jpg)", "*.jpg");
            FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG File (*.png)", "*.png");
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().addAll(jpgFilter, pngFilter);
            File file = chooser.showOpenDialog(new Stage());
            addfileF.setText(file.getAbsolutePath());
        });
        careerGrid.add(new HBox(5, addfileF, addfileB), 2, 2);

        TextField addundesF = new TextField();
        addundesF.setMinSize(careerfw, careerfh);
        addundesF.setMaxSize(careerfw, careerfh);
        careerGrid.add(addundesF, 2, 3);

        TextField addlastnameF = new TextField();
        addlastnameF.setMinSize(careerfw, careerfh);
        addlastnameF.setMaxSize(careerfw, careerfh);
        careerGrid.add(addlastnameF, 2, 4);

        TextField addfirstnameF = new TextField();
        addfirstnameF.setMinSize(careerfw, careerfh);
        addfirstnameF.setMaxSize(careerfw, careerfh);
        careerGrid.add(addfirstnameF, 2, 5);

        ToggleGroup addgenderG = new ToggleGroup();
        RadioButton addmaleR = new RadioButton("Эрэгтэй");
        RadioButton addfemaleR = new RadioButton("Эмэгтэй");
        addgenderG.getToggles().addAll(addmaleR, addfemaleR);
        FlowPane addgenders = new FlowPane(addmaleR, addfemaleR);
        careerGrid.add(addgenders, 2, 6);

        GridPane birthdayGrid = new GridPane();
        birthdayGrid.setVgap(5);
        TextField addbirthdayYearF = new TextField();
        addbirthdayYearF.setMinSize(careerfw / 3, careerfh);
        addbirthdayYearF.setMaxSize(careerfw / 3, careerfh);
        TextField addbirhtdayMonthF = new TextField();
        addbirhtdayMonthF.setMinSize(careerfw / 3, careerfh);
        addbirhtdayMonthF.setMaxSize(careerfw / 3, careerfh);
        TextField addbirthdayDayF = new TextField();
        addbirthdayDayF.setMaxSize(careerfw / 3, careerfh);
        addbirthdayDayF.setMinSize(careerfw / 3, careerfh);
        birthdayGrid.add(new Label("Он"), 1, 1);
        birthdayGrid.add(addbirthdayYearF, 1, 2);
        birthdayGrid.add(new Label("Сар"), 2, 1);
        birthdayGrid.add(addbirhtdayMonthF, 2, 2);
        birthdayGrid.add(new Label("Өдөр"), 3, 1);
        birthdayGrid.add(addbirthdayDayF, 3, 2);
        birthdayGrid.setMinSize(careerfw, 50);
        birthdayGrid.setMaxSize(careerfw, 50);
        careerGrid.add(birthdayGrid, 2, 7);

        TextField addphoneF = new TextField();
        addphoneF.setMinSize(careerfw, careerfh);
        addphoneF.setMaxSize(careerfw, careerfh);
        careerGrid.add(addphoneF, 2, 8);

        TextField addaddressF = new TextField();
        addaddressF.setMinSize(careerfw, careerfh);
        addaddressF.setMaxSize(careerfw, careerfh);
        careerGrid.add(addaddressF, 2, 9);

        TextField addregF = new TextField();
        addregF.setMinSize(careerfw, careerfh);
        addregF.setMaxSize(careerfw, careerfh);
        careerGrid.add(addregF, 2, 10);

        TextField addidentityF = new TextField();
        addidentityF.setMinSize(careerfw, careerfh);
        addidentityF.setMaxSize(careerfw, careerfh);
        careerGrid.add(addidentityF, 2, 11);

        TextField addcareerF = new TextField();
        addcareerF.setMinSize(careerfw, careerfh);
        addcareerF.setMaxSize(careerfw, careerfh);
        careerGrid.add(addcareerF, 2, 12);

        ComboBox addeduCombo = new ComboBox(educationList);
        addeduCombo.setMinSize(careerfw, careerfh);
        addeduCombo.setMaxSize(careerfw, careerfh);
        addeduCombo.getSelectionModel().select(0);
        careerGrid.add(addeduCombo, 2, 13);

        ComboBox addmarriedCombo = new ComboBox(marriedList);
        addmarriedCombo.setMinSize(careerfw, careerfh);
        addmarriedCombo.setMaxSize(careerfw, careerfh);
        addmarriedCombo.getSelectionModel().select(0);
        careerGrid.add(addmarriedCombo, 2, 14);

        GridPane educationGrid = new GridPane();
        educationGrid.setStyle("-fx-background-color: #FAFCFC; -fx-border-width: 1px; -fx-border-style: solid; -fx-border-color: #D2D5D6;");
        educationGrid.setVgap(10);
        educationGrid.setHgap(5);
        educationGrid.setPadding(new Insets(10, 10, 10, 10));
        Label educationGridLabel = new Label("Боловсрол");
        educationGrid.add(educationGridLabel, 1, 1);
        educationGridLabel.setFont(new Font("Berlin Sans FB", 16));
        educationGridLabel.setAlignment(Pos.CENTER);
        educationGridLabel.setPrefSize(250, 25);
        GridPane.setColumnSpan(educationGridLabel, 2);

        Label addhighLabel = new Label("10 жил");
        educationGrid.add(addhighLabel, 1, 2);
        TextField addhighF = new TextField();
        educationGrid.add(addhighF, 2, 2);
        Label adduniLabel = new Label("Дээд сургууль");
        educationGrid.add(adduniLabel, 1, 3);
        TextField adduniF = new TextField();
        educationGrid.add(adduniF, 2, 3);

        Label addlangLabel = new Label("Хэлний мэдлэг");
        educationGrid.add(addlangLabel, 1, 4);
        GridPane addlangGrid = new GridPane();
        addlangGrid.setVgap(5);
        addlangGrid.setHgap(5);
        ObservableList<CheckBox> langCheckboxes = FXCollections.observableArrayList();
        langCheckboxes.add(new CheckBox("Англи"));
        langCheckboxes.add(new CheckBox("Орос"));
        langCheckboxes.add(new CheckBox("Герман"));
        langCheckboxes.add(new CheckBox("Хятад"));
        langCheckboxes.add(new CheckBox("Япон"));
        for (int i = 0; i < langCheckboxes.size(); i++) {
            addlangGrid.add(langCheckboxes.get(i), 2, i + 1);
        }
        Label addlangOtherLabel = new Label("Бусад");
        addlangGrid.add(addlangOtherLabel, 1, 6);
        TextField addlangOtherF = new TextField();
        addlangGrid.add(addlangOtherF, 2, 6);
        educationGrid.add(addlangGrid, 2, 4);

        Label addcomLabel = new Label("Компьютерийн мэдлэг");
        educationGrid.add(addcomLabel, 1, 5);
        GridPane addcomGrid = new GridPane();
        addcomGrid.setVgap(5);
        addcomGrid.setHgap(5);
        ToggleGroup addcomRadioGroup = new ToggleGroup();
        RadioButton addcomBadR = new RadioButton("Муу");
        addcomGrid.add(addcomBadR, 1, 1);
        RadioButton addcomMediumR = new RadioButton("Дунд");
        addcomGrid.add(addcomMediumR, 1, 2);
        RadioButton addcomGoodR = new RadioButton("Сайн");
        addcomGrid.add(addcomGoodR, 1, 3);
        RadioButton addcomBestR = new RadioButton("Маш сайн");
        addcomGrid.add(addcomBestR, 1, 4);
        addcomRadioGroup.getToggles().addAll(addcomBadR, addcomMediumR, addcomGoodR, addcomBestR);
        educationGrid.add(addcomGrid, 2, 5);

        HBox center = new HBox(15, careerGrid, educationGrid);
        center.setPadding(new Insets(10, 10, 10, 10));

        Button otherButton = new Button("Буцах");
        otherButton.setOnAction((event) -> switchToScene(indexScene));
        Button insertButton = new Button("Оруулах");
        insertButton.setOnAction((event) -> {
            String undes = "",
                    lastname = "",
                    firstname = "",
                    gender = "",
                    birthday = "",
                    phone = "",
                    address = "",
                    registrationNum = "",
                    identityNum = "",
                    career = "",
                    education = "",
                    married = "",
                    highschool = "",
                    university = "",
                    language = "",
                    computerKnowledge = "",
                    img = "";

            // Your validation here!
            boolean everythingSet = false;
            if (addfileF.getText().equals("")) {
                addfileF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                img = addfileF.getText();
                everythingSet = true;
            }

            if (addundesF.getText().equals("")) {
                addundesF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                undes = addundesF.getText();
                everythingSet = true;
            }

            if (addlastnameF.getText().equals("")) {
                addlastnameF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                lastname = addlastnameF.getText();
                everythingSet = true;
            }

            if (addfirstnameF.getText().equals("")) {
                addfirstnameF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                firstname = addfirstnameF.getText();
                everythingSet = true;
            }

            if (addmaleR.isSelected() && !addfemaleR.isSelected()) {
                gender = addmaleR.getText();
                everythingSet = true;
            } else if (addfemaleR.isSelected() && !addmaleR.isSelected()) {
                gender = addfemaleR.getText();
                everythingSet = true;
            } else if (!addmaleR.isSelected() || !addfemaleR.isSelected()) {
                addmaleR.setStyle("-fx-border-color: red");
                addfemaleR.setStyle("-fx-border-color: red");
                everythingSet = false;
            }

//            if (addbirthdayDayF.getText().equals("")) {
//                addbirthdayDayF.setStyle("-fx-border-color: red");
//                everythingSet = false;
//            } else {
//                birthday = addbirthdayDayF.getText();
//                everythingSet = true;
//            }
            if (addbirthdayYearF.getText().equals("")) {
                addbirthdayYearF.setStyle("-fx-border-color: red");
                everythingSet = false;
            }
            if (addbirhtdayMonthF.getText().equals("")) {
                addbirhtdayMonthF.setStyle("-fx-border-color: red");
                everythingSet = false;
            }
            if (addbirthdayDayF.getText().equals("")) {
                addbirthdayDayF.setStyle("-fx-border-color: red");
                everythingSet = false;
            }
            if (!addbirthdayYearF.equals("") && !addbirhtdayMonthF.getText().equals("") && !addbirthdayDayF.getText().equals("")) {
                birthday = addbirthdayYearF.getText() + "-" + addbirhtdayMonthF.getText() + "-" + addbirthdayDayF.getText();
                everythingSet = true;
            }

            if (addphoneF.getText().equals("")) {
                addphoneF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                phone = addphoneF.getText();
                everythingSet = true;
            }

            if (addaddressF.getText().equals("")) {
                addaddressF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                address = addaddressF.getText();
                everythingSet = true;
            }

            if (addregF.getText().equals("")) {
                addregF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                registrationNum = addregF.getText();
                everythingSet = true;
            }

            if (addidentityF.getText().equals("")) {
                addidentityF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                identityNum = addidentityF.getText();
                everythingSet = true;
            }

            if (addcareerF.getText().equals("")) {
                addcareerF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                career = addcareerF.getText();
                everythingSet = true;
            }

            if (addeduCombo.getSelectionModel().getSelectedIndex() < 0) {
                addeduCombo.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                education = addeduCombo.getSelectionModel().getSelectedItem().toString();
                everythingSet = true;
            }

            if (addmarriedCombo.getSelectionModel().getSelectedIndex() < 0) {
                addmarriedCombo.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                married = addmarriedCombo.getSelectionModel().getSelectedItem().toString();
                everythingSet = true;
            }

            if (addhighF.getText().equals("")) {
                addhighF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                highschool = addhighF.getText();
                everythingSet = true;
            }

            if (adduniF.getText().equals("")) {
                adduniF.setStyle("-fx-border-color: red");
                everythingSet = false;
            } else {
                university = adduniF.getText();
                everythingSet = true;
            }

            for (CheckBox check : langCheckboxes) {
                if (check.isSelected()) {
                    language += check.getText();
                    language += ", ";
                }
            }
            language += addlangOtherF.getText();
            language.substring(0, language.lastIndexOf(",") - 1);

            if (addcomBadR.isSelected()) {
                computerKnowledge = addcomBadR.getText();
                everythingSet = true;
            } else if (addcomMediumR.isSelected()) {
                computerKnowledge = addcomMediumR.getText();
                everythingSet = true;
            } else if (addcomGoodR.isSelected()) {
                computerKnowledge = addcomGoodR.getText();
                everythingSet = true;
            } else if (addcomBestR.isSelected()) {
                computerKnowledge = addcomBestR.getText();
                everythingSet = true;
            } else {
                addcomBadR.setStyle("-fx-border-color: red");
                addcomMediumR.setStyle("-fx-border-color: red");
                addcomGoodR.setStyle("-fx-border-color: red");
                addcomBestR.setStyle("-fx-border-color: red");
                everythingSet = false;
            }

            if (everythingSet) {
                Person person = new Person();
                person.setUndes(undes);
                person.setLastname(lastname);
                person.setFirstname(firstname);
                person.setGender(gender);
                person.setBirthday(birthday);
                person.setPhone(phone);
                person.setAddress(address);
                person.setRegistrationNum(registrationNum);
                person.setIdentityNum(identityNum);
                person.setCareer(career);
                person.setEducation(education);
                person.setMarried(married);
                person.setHighschool(highschool);
                person.setUniversity(university);
                person.setLanguage(language);
                person.setComputerKnowledge(computerKnowledge);
                person.setImg(img);
                person.setId(""+insertPerson(person));
                tableItems.add(person);
                switchToScene(indexScene);
            }
        });
        FlowPane footer = new FlowPane(15, 10, otherButton, insertButton);
        footer.setPadding(new Insets(10, 10, 10, 10));

        bpane.setCenter(new ScrollPane(center));
        bpane.setBottom(footer);

        addScene = new Scene(bpane);
    }

    private void loginScene() {
        int lwidth = 100;
        int lheight = 25;

        int fwidth = 200;
        int fheight = 25;
        int spacing = 10;

        Font labelFont = new Font("Berlin Sans FB", 18);

        ImageView image = new ImageView(new Image("practical/resources/login-icon.png"));
        image.setPreserveRatio(true);

        Label userLabel = new Label("Нэр");
        userLabel.setPrefSize(lwidth, lheight);
        userLabel.setFont(labelFont);
        Label passLabel = new Label("Нууц үг");
        passLabel.setPrefSize(lwidth, lheight);
        passLabel.setFont(labelFont);
        Label gapLabel = new Label("");
        gapLabel.setPrefSize(lwidth + 145, lheight);
        gapLabel.setFont(new Font("Berlin Sans FB", 16));
        TextField userField = new TextField();
        userField.setPrefSize(fwidth, fheight);
        PasswordField passField = new PasswordField();
        passField.setPrefSize(fwidth, fheight);

        Button loginButton = new Button("Нэвтрэх");
        loginButton.setOnAction((event) -> {
            if (loginProcess(userField.getText(), passField.getText())) {
                gapLabel.setStyle("-fx-text-fill: green");
                gapLabel.setText("Амжилттай!");
                switchToScene(indexScene);
            } else {
                gapLabel.setStyle("-fx-text-fill: red");
                gapLabel.setText("Нэр эсвэл нууц үг буруу байна!");
            }
        });

        HBox userBox = new HBox(spacing, userLabel, userField);
        HBox passBox = new HBox(spacing, passLabel, passField);
        HBox logBox = new HBox(spacing, gapLabel, loginButton);
        VBox loginFace = new VBox(10, userBox, passBox, logBox);
        loginFace.setPadding(new Insets(15, 15, 0, 0));

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(image);
        borderPane.setRight(loginFace);
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        loginScene = new Scene(borderPane);
        loginScene.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (loginProcess(userField.getText(), passField.getText())) {
                    gapLabel.setStyle("-fx-text-fill: green");
                    gapLabel.setText("Амжилттай!");
                    switchToScene(indexScene);
                } else {
                    gapLabel.setStyle("-fx-text-fill: red");
                    gapLabel.setText("Нэр эсвэл нууц үг буруу байна!");
                }
            }
        });
    }

    private boolean loginProcess(String username, String password) {

        ResultSet result = db.select("select username, password from account");
        if (!username.equals("") && username != null && !password.equals("") && password != null) {
            try {
                while (result.next()) {
                    if (username.equals(result.getString("username"))
                            && password.equals(result.getString("password"))) {
                        return true;
                    }
                }
            } catch (SQLException ex) {
                return false;
            }
        }

        return false;
    }

    private void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    private void switchToScene(Scene scene) {
        delay(100);
        stage.setScene(scene);
    }

    private int insertPerson(Person person) {
        try {
            PreparedStatement ps = db.connection.prepareStatement("insert into person values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
            ps.setString(1, person.getUndes());
            ps.setString(2, person.getLastname());
            ps.setString(3, person.getFirstname());
            ps.setString(4, person.getGender());
            ps.setString(5, person.getBirthday());
            ps.setString(6, person.getPhone());
            ps.setString(7, person.getAddress());
            ps.setString(8, person.getRegistrationNum());
            ps.setString(9, person.getIdentityNum());
            ps.setString(10, person.getCareer());
            ps.setString(11, person.getEducation());
            ps.setString(12, person.getMarried());
            ps.setString(13, person.getHighschool());
            ps.setString(14, person.getUniversity());
            ps.setString(15, person.getLanguage());
            ps.setString(16, person.getComputerKnowledge());
            ps.setString(17, person.getImg());
            ps.executeUpdate();
            
            ResultSet res = db.select("select id from person order by id desc limit 1");
            int id = 0;
            while (res.next()) {
                id = res.getInt("id");
            }
            
            PreparedStatement ps1 = db.connection.prepareStatement("insert into permission(person_id) values (?)");
            ps1.setInt(1, id);
            ps1.executeUpdate();
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private void updatePerson(Person person, int id) {
        try {
            PreparedStatement ps = db.connection.prepareStatement("update person set "
                    + "undes = ?, "
                    + "lastname = ?, "
                    + "firstname = ?, "
                    + "gender = ?, "
                    + "birthday = ?, "
                    + "phone = ?, "
                    + "address = ?, "
                    + "registrationNum = ?, "
                    + "identityNum = ?, "
                    + "career = ?, "
                    + "education = ?, "
                    + "married = ?, "
                    + "highschool = ?, "
                    + "university = ?, "
                    + "language = ?, "
                    + "computerKnowledge = ?, "
                    + "img = ? "
                    + "where id = ?");
            ps.setString(1, person.getUndes());
            ps.setString(2, person.getLastname());
            ps.setString(3, person.getFirstname());
            ps.setString(4, person.getGender());
            ps.setString(5, person.getBirthday());
            ps.setString(6, person.getPhone());
            ps.setString(7, person.getAddress());
            ps.setString(8, person.getRegistrationNum());
            ps.setString(9, person.getIdentityNum());
            ps.setString(10, person.getCareer());
            ps.setString(11, person.getEducation());
            ps.setString(12, person.getMarried());
            ps.setString(13, person.getHighschool());
            ps.setString(14, person.getUniversity());
            ps.setString(15, person.getLanguage());
            ps.setString(16, person.getComputerKnowledge());
            ps.setString(17, person.getImg());
            ps.setInt(18, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}