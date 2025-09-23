package org.anton.enums;

import lombok.Getter;

@Getter
public enum CategoryDropdown {
    ALL_DEPARTMENTS("All Departments"),
    ARTS_AND_CRAFTS("Arts & Crafts"),
    AUTOMOTIVE("Automotive"),
    BABY("Baby"),
    BEAUTY_AND_PERSONAL_CARE("Beauty & Personal Care"),
    BOOKS("Books"),
    BOYS_FASHION("Boys' Fashion"),
    COMPUTERS("Computers"),
    DEALS("Deals"),
    DIGITAL_MUSIC("Digital Music"),
    ELECTRONICS("Electronics"),
    GIRLS_FASHION("Girls' Fashion"),
    HEALTH_AND_HOUSEHOLD("Health & Household"),
    HOME_AND_KITCHEN("Home & Kitchen"),
    INDUSTRIAL_AND_SCIENTIFIC("Industrial & Scientific"),
    KINDLE_STORE("Kindle Store"),
    LUGGAGE("Luggage"),
    MENS_FASHION("Men's Fashion"),
    MOVIES_AND_TV("Movies & TV"),
    MUSIC_CDs_AND_VINYL("Music, CDs & Vinyl"),
    PET_SUPPLIES("Pet Supplies"),
    PRIME_VIDEO("Prime Video"),
    SOFTWARE("Software"),
    SPORTS_AND_OUTDOORS("Sports & Outdoors"),
    TOOLS_AND_HOME_IMPROVEMENT("Tools & Home Improvement"),
    TOYS_AND_GAMES("Toys & Games"),
    VIDEO_GAMES("Video Games"),
    WOMENS_FASHION("Women's Fashion"),
    ;


    private final String displayName;

    CategoryDropdown(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
