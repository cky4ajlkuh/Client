import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Sosiska {
    int number;
    char value;

    Sosiska(int number, char value) {
        this.number = number;
        this.value = value;
    }

    public Sosiska() {
    }

    public int getNumber() {
        return number;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
