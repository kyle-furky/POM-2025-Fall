package pages;

public interface Clickable {
    void click();
}
    class Button implements Clickable{
        public void click(){
            System.out.println("Button clicked");
        }
    }



