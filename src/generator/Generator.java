package generator;


import java.util.List;

public interface Generator {
    public void generate();
    public void print();
    public int getModule();
    public List<Integer> getValues();
}
