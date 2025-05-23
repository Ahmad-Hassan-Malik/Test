public class Patient {
    String type;
    String id;

    public Patient(String type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
