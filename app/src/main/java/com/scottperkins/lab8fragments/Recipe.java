package com.scottperkins.lab8fragments;

public class Recipe {
    private String name;
    private String description;

    public static final Recipe[] recipes =
            {new Recipe( "Blueberry muffin", "1 Cupblueberries\n1 Tablespoon flour\n1 Litre water"),
                    new Recipe( "Sponge Cake", "1 Cup sponge\n2millilitres vanilla"),
                    new Recipe( "Apple Pie", "3 Apples\n1 pastry")};
    public Recipe(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    public String getName()
    {
        return this.name;
    }
    public String getDescription()
    {
        return this.description;
    }
    @Override
    public String toString()
    {
        return this.name;
    }
}
