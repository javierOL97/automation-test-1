const puppeteer = require('puppeteer');
const expectPuppeteer = require("expect-puppeteer");
let webBrowser;
let page;

describe('Tests', () => {
    beforeAll(async () => {
        webBrowser = await puppeteer.launch({headless:true});
        page = await webBrowser.newPage();
        let url = "http://localhost:3000/shows/"
        await page.goto(url);
    });

    test('should be empty search box', async () => {
        await expectPuppeteer(page).toFill('.validate', '');
    });

    test('should click on search button', async () => {
        await expectPuppeteer(page).toClick('button', {text: 'Search'});
        console.log("Button was pressed correctly");
    });

    test('should show a message', async () => {
        await page.waitForXPath("//span[contains(text(),'Search cannot be empty')]");
        let isTrue = await page.evaluate(() => {
            const message = "Search cannot be empty";
            const selector = '.helper-text';
            return document.querySelector(selector).innerText.includes(message);
        });
        console.log(isTrue);
        await expect(isTrue).toBeTruthy();
    });

    test('should search for "batman" and click on search button', async () =>{
        await expectPuppeteer(page).toFill('input[name="search"]', 'batman');
        await expectPuppeteer(page).toClick('button', {text: 'Search'});
    });

    test('should first card not have an image', async () =>{
        await page.waitForSelector('div[class="container"] > a');
        let imgSelector = 'div:nth-child(3) > div > div > div > div > div.col.s6 > img'
        let card = await page.$(
            imgSelector);
        //determines whether value of imgSelector is null
        console.log(card);
        await expect(card).toBeFalsy();
    });

    afterAll(async () => {
        await webBrowser.close();
    });
});