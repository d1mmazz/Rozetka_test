public class XPath {
    String myUrl = "https://rozetka.com.ua/";
    String search = "//*[@class='search-form__input ng-untouched ng-pristine ng-valid']";
    String press_search = "//*[contains(text(), 'Найти')]";
    String rozetka = "//label[@for='Rozetka']";
    String gForce = "//label[@for='GeForce 210']";
    String priceSort = "//option[contains(text(),' От дешевых к дорогим ')]";
    String goods = "//a[@class='goods-tile__heading ng-star-inserted']";
    String prices = "//span[@class='goods-tile__price-value']";
}
