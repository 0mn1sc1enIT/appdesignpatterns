package model;

public class Computer {
    public String CPU;
    public String RAM;
    public String HDD;
    public String GPU;
    public String OS;

    public Computer(String CPU, String RAM, String HDD, String GPU, String OS) {
        this.CPU = CPU;
        this.GPU = GPU;
        this.HDD = HDD;
        this.OS = OS;
        this.RAM = RAM;
    }

    public Computer() {};

    public String ToString()
    {
        return STR."Компьютер: CPU - {\{CPU}}, RAM - {\{RAM}}, Накопитель - {\{HDD}}, GPU - {\{GPU}}, ОС - {\{OS}}";
    }
}
