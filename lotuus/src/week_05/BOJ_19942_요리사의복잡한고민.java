package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19942_요리사의복잡한고민 {

    static int N;
    static Goal goal;
    static Ingredient[] ingredients;
    static int minPrice = Integer.MAX_VALUE;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        //최소영양성분
        st = new StringTokenizer(br.readLine());
        goal = new Goal();
        goal.setProtein(Integer.parseInt(st.nextToken()));
        goal.setFat(Integer.parseInt(st.nextToken()));
        goal.setCarbohydrate(Integer.parseInt(st.nextToken()));
        goal.setVitamin(Integer.parseInt(st.nextToken()));

        //재료
        ingredients = new Ingredient[N];
        selected = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Ingredient ingredient = new Ingredient();
            ingredient.setProtein(Integer.parseInt(st.nextToken()));
            ingredient.setFat(Integer.parseInt(st.nextToken()));
            ingredient.setCarbohydrate(Integer.parseInt(st.nextToken()));
            ingredient.setVitamin(Integer.parseInt(st.nextToken()));
            ingredient.setPrice(Integer.parseInt(st.nextToken()));
            ingredients[i] = ingredient;
        }

        recursion(0, 0, 0 ,0, 0, 0);

//        if(selected){
//
//        }

        System.out.println(minPrice);
//        System.out.println(Arrays.toString(selectedIngredient));
    }

    private static void recursion(int index, int protein, int fat, int carbohydrate, int vitamin, int price) {
        //재료를 모두 순회한경우
        if(index == N){
            return;
        }

        //최소영양기준을 만족하는지 확인
        boolean standard = goal.getProtein() <= protein
                && goal.getFat() <= fat
                && goal.getCarbohydrate() <= carbohydrate
                && goal.getVitamin() <= vitamin;
        if(!standard){
            return;
        }

        //최소비용인지 확인
        if(price <= minPrice){
            minPrice = price;
        }

        //사용한 재료의 번호 입력
        selected[index] = true;

        //재료를 사용하는 경우
        recursion(index+1,
                protein + ingredients[index].getProtein(),
                fat + ingredients[index].getFat(),
                carbohydrate + ingredients[index].getCarbohydrate(),
                vitamin + ingredients[index].getVitamin(),
                price + ingredients[index].getPrice());

        selected[index] = false;

        //재료를 사용하지 않는 경우
        recursion(index+1, protein, fat, carbohydrate, vitamin, price);

    }

}


class Goal {

    private int protein; //단백질
    private int fat; //지방
    private int carbohydrate; //탄수화물
    private int vitamin; //비타민

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getVitamin() {
        return vitamin;
    }

    public void setVitamin(int vitamin) {
        this.vitamin = vitamin;
    }
}



class Ingredient {

    private int protein; //단백질
    private int fat; //지방
    private int carbohydrate; //탄수화물
    private int vitamin; //비타민
    private int price; //가격

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getVitamin() {
        return vitamin;
    }

    public void setVitamin(int vitamin) {
        this.vitamin = vitamin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}