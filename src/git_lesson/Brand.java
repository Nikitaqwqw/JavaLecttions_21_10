package git_lesson;

public class Brand {

    private String brandName;

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandName='" + brandName + '\'' +
                '}';
    }
}
