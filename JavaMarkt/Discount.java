package pl.michalbidzinski;

public interface Discount {
    void execute(Cart cart) throws Exception;
}
