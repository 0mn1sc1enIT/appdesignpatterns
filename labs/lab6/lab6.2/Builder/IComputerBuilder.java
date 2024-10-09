package Builder;

import model.Computer;

public interface IComputerBuilder {
    public void SetCPU();
    public void SetRAM();
    public void SetHDD();
    public void SetGPU();
    public void SetOS();
    public Computer getComputer();
}
