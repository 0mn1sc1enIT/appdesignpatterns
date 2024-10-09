import Builder.IComputerBuilder;
import model.Computer;

public class ComputerDirector {
    private IComputerBuilder builder;
    public ComputerDirector(IComputerBuilder builder) {
        this.builder = builder;
    }
    public void ConstructComputer() {
        builder.SetCPU();
        builder.SetGPU();
        builder.SetHDD();
        builder.SetRAM();
        builder.SetOS();
    }
    public Computer GetComputer() {
        return builder.getComputer();
    }
}
