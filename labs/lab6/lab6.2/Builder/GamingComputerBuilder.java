package Builder;

import model.Computer;

public class GamingComputerBuilder implements IComputerBuilder {
    private Computer computer = new Computer();
    @Override
    public void SetCPU() {
        computer.CPU = "Intel i9";
    }

    @Override
    public void SetRAM() {
        computer.RAM = "32GB";
    }

    @Override
    public void SetHDD() {
        computer.HDD = "1TB SSD";
    }

    @Override
    public void SetGPU() {
        computer.GPU = "NVIDIA RTX 3080";
    }

    @Override
    public void SetOS() {
        computer.OS = "Windows 11";
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}