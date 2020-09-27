public class Patient {
    private int id;
    private int idCard;
    private String name;
    private String surName;
    private  String diagnoze;

    Patient(int id, int idCard, String name, String surName,String diagnoze){
        this.id = id;
        this.idCard= idCard;
        this.name = name;
        this.surName = surName;
        this.diagnoze = diagnoze;

    }

    public String getDiagnoze() {
        return diagnoze;
    }

    public void setDiagnoze(String diagnoze) {
        this.diagnoze = diagnoze;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }








}
