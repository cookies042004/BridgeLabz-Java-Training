package generics;

// meal plan interface
interface MealPlan {
    void showMeal();
}

// different meal types
class VegetarianMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegetarian Meal: Dal, Rice, Vegetables");
    }
}

class VeganMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegan Meal: Salad, Fruits, Nuts");
    }
}

class KetoMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Keto Meal: Eggs, Cheese, Avocado");
    }
}

class HighProteinMeal implements MealPlan {
    public void showMeal() {
        System.out.println("High Protein Meal: Chicken, Beans, Eggs");
    }
}

// generic meal class
class Meal<T extends MealPlan> {
    T mealPlan;

    Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    void displayMeal() {
        mealPlan.showMeal();
    }
}

// class utility with generic method
class MealPlanUtil {

    // Generic method to generate meal plan
    static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        return new Meal<>(plan);
    }
}

public class PersonaliseMeal {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal =
                MealPlanUtil.generateMealPlan(new VegetarianMeal());

        Meal<VeganMeal> veganMeal =
                MealPlanUtil.generateMealPlan(new VeganMeal());

        Meal<KetoMeal> ketoMeal =
                MealPlanUtil.generateMealPlan(new KetoMeal());

        Meal<HighProteinMeal> proteinMeal =
                MealPlanUtil.generateMealPlan(new HighProteinMeal());

        vegMeal.displayMeal();
        veganMeal.displayMeal();
        ketoMeal.displayMeal();
        proteinMeal.displayMeal();
    }
}

