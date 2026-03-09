package vod.repository.mem;

import vod.model.Chef;
import vod.model.Dish;
import vod.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Restaurant> restauracje = new ArrayList<>();

    static List<Chef> chefs = new ArrayList<>();

    static List<Dish> dishes = new ArrayList<>();

    static {

        Chef smarzowski = new Chef(1, "Wojciech", "Smarzowski");
        Chef vega = new Chef(2, "Patryk", "Vega");
        Chef wajda = new Chef(3, "Andrzej", "Wajda");
        Chef skolimowski = new Chef(4, "Jerzy", "Skolimowski");

        Dish wolyn = new Dish(1, "Wolyn", "https://ocdn.eu/pulscms-transforms/1/D0gk9kuTURBXy8zYzFhMDRhZS1jOGRiLTQxN2YtOTcwYy1iNjRjZDBkMjc4MDYuanBlZ5GTBc0DFM0BvIGhMAU", smarzowski, (float) 4.1);
        Dish wesele = new Dish(2, "Wesele", "https://fwcdn.pl/fpo/40/98/124098/7521214.6.jpg", smarzowski, (float) 4.3);

        Dish polityka = new Dish(3, "Polityka", "https://i.iplsc.com/-/00094J03E94SMPSS-C122.jpg", vega, (float) 3.9);
        Dish pitbul = new Dish(4, "Pitbul", "https://bi.im-g.pl/im/5b/9b/12/z19510363V,-Pitbull--Nowe-porzadki---rez--Patryk-Vega--plakat.jpg", vega, (float) 3.1);

        Dish katyn = new Dish(5, "Katyn", "http://www.gokmichalowo.pl/imprezy2007/katyn/plakat_maly.jpg", wajda, (float) 4.7);
        Dish tatarak = new Dish(6, "Tatarak", "http://gapla.fn.org.pl/public/cache/P21829-483x700.jpg", wajda, (float) 4.4);

        Dish essential = new Dish(7, "Essential killing", "https://m.media-amazon.com/images/M/MV5BNTE5NjAxMTEzNl5BMl5BanBnXkFtZTcwMjYzMDQ0Ng@@._V1_UX182_CR0,0,182,268_AL_.jpg", skolimowski, (float) 4.9);
        Dish ferdydurke = new Dish(8, "Ferdydurke", "http://gapla.fn.org.pl/public/cache/P19423-483x700.jpg", skolimowski, (float) 4.3);

        bind(wolyn, smarzowski);
        bind(wesele, smarzowski);

        bind(polityka, vega);
        bind(pitbul, vega);

        bind(katyn, wajda);
        bind(tatarak, wajda);

        bind(essential, skolimowski);
        bind(ferdydurke, skolimowski);

        Restaurant kebab = new Restaurant(1, "kebab pajda", "https://www.kinoteka.pl/img/logo.png");
        Restaurant barMleczny = new Restaurant(2, "Bar mleczny Smakosz", "http://www.festiwalfilmuniemego.pl/wp-content/uploads/2015/11/Kino-pod-Baranami.png");
        Restaurant pizzeria = new Restaurant(3, "Pizzeria u frediego", "https://i2.wp.com/garretreza.pl/wp-content/uploads/2018/07/nh.jpg");
        Restaurant burgerownia = new Restaurant(4, "Burger z dużym kotletem", "https://static2.s-trojmiasto.pl/zdj/c/n/19/2276/250x0/2276445.jpg");

        bind(kebab, wesele);
        bind(pizzeria, wesele);
        bind(pizzeria, wolyn);
        bind(pizzeria, polityka);

        bind(kebab, tatarak);
        bind(burgerownia, tatarak);
        bind(burgerownia, essential);
        bind(barMleczny, essential);
        bind(barMleczny, polityka);

        dishes.add(wolyn);
        dishes.add(wesele);
        dishes.add(polityka);
        dishes.add(pitbul);
        dishes.add(katyn);
        dishes.add(tatarak);
        dishes.add(essential);
        dishes.add(ferdydurke);

        chefs.add(smarzowski);
        chefs.add(vega);
        chefs.add(wajda);
        chefs.add(skolimowski);

        restauracje.add(kebab);
        restauracje.add(barMleczny);
        restauracje.add(pizzeria);
        restauracje.add(burgerownia);

    }

    private static void bind(Restaurant c, Dish m) {
        c.addMovie(m);
        m.addCinema(c);
    }

    private static void bind(Dish m, Chef d) {
        d.addMovie(m);
        m.setDirector(d);
    }

}
