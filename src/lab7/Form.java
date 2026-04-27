package lab7;

public class Form {
    private String color;
    private static int instanceCount;

    public Form()
    {
        color = "white";
        instanceCount++;
    }

    public Form(String color)
    {
        this.color = color;
        instanceCount++;
    }

    public float getArea() {
        return 0;
    }

    public String toString() {
        return "This form has the color " + color;
    }

    public static int getInstanceCount ()
    {
        return instanceCount;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Form) {
            Form f = (Form) obj;
            if (this.color == null && f.color == null) {
                return true;
            } else if (this.color != null && f.color != null && this.color.compareTo(f.color) == 0) {
                return true;
            }
        }
        return false;
    }
}
