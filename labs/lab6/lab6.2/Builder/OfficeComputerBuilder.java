package Builder;

import model.Computer;

public class OfficeComputerBuilder implements IComputerBuilder {
    private Computer computer = new Computer();
    @Override
    public void SetCPU() {
        computer.CPU = "Intel i3";
    }

    @Override
    public void SetRAM() {
        computer.RAM = "8GB";
    }

    @Override
    public void SetHDD() {
        computer.HDD = "1TB HDD";
    }

    @Override
    public void SetGPU() {
        computer.GPU = "Integrated";
    }

    @Override
    public void SetOS() {
        computer.OS = "Windows 10";
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
