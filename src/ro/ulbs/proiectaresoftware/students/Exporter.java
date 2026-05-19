package ro.ulbs.proiectaresoftware.students;
import java.util.List;

public class Exporter
{
    private IStudentiExport strategy;
    public void setStrategy(IStudentiExport strategy)
    {
        this.strategy = strategy;
    }
    void startExport(List<Student> students)
    {
        strategy.doExport(students);
    }
}
