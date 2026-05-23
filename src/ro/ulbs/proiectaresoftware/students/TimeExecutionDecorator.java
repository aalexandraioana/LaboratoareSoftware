package ro.ulbs.proiectaresoftware.students;
import java.util.ArrayList;
import java.util.List;

public class TimeExecutionDecorator extends TimeExecution
{
    private List<Student> studenti;

    public TimeExecutionDecorator(IStudentiExport exporter, List<Student> studenti)
    {
        super(exporter);
        this.studenti = new ArrayList<>();
    }

    @Override
    public long executionTime(List<Student> studenti)
    {
        long time = super.executionTime(studenti);
        System.out.println("Execution time: " + time + " ms for " + exporter);
        return time;
    }
}
