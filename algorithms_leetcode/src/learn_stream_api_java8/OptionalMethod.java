package learn_stream_api_java8;

import java.util.Optional;

class Outfit {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Girl {
    private Outfit outfit;

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}

public class OptionalMethod {
    public static void main(String[] args) {
//        String message = "Co gia tri roi ne";
        String message = null;
        Optional<String> messageOptional = Optional.ofNullable(message);
        if (messageOptional.isPresent()) {
            System.out.println(messageOptional.get());
        }

        // Su dung orElse() lay ra Object trong Optional. Neu null tra ve gia tri mac dinh trong orElse().
        String newMessage1 = messageOptional.orElse("Du lieu mac dinh");
        System.out.println(newMessage1);

        String newMessage2 = messageOptional.orElseGet(() -> {
            StringBuilder sb = new StringBuilder("Noi chuoi moi vao neu gia tri null ne");
            return sb.toString();
        });
        System.out.println(newMessage2);

        Girl girl = new Girl();
        Outfit outfit = new Outfit();
        outfit.setType("Bikini ren");
        girl.setOutfit(outfit);
        System.out.println(getOutfitType(girl));
    }

    private static String getOutfitType(Girl girl) {
        return Optional.ofNullable(girl)
                .map(Girl::getOutfit)
                .map(Outfit::getType)
                .orElse("Coi chuong");
    }
}
