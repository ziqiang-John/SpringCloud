package pattern.builder;

public class BuilderpatternDemo {
    public static void main(String[] args){
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVagMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total cost "+vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost "+nonVegMeal.getCost());

    }
}
