public class Dog extends Animal {

    private String color;

    public Dog() {

    }

    private Dog(String color) {
        this.color = color;
    }

    private void walk() {
        System.out.println("walk");
    }

    private void run() {
        System.out.println("run");
    }

    private void jump() {
        System.out.println("jump");
    }
}
