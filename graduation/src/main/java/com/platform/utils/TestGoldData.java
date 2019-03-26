package com.platform.utils;

import com.xst.golddata.GoldSpider;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestExecutionListeners;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-18 12:38
 */
public class TestGoldData {

    @Test
    public void testGoldSpider(){
        String ruleContent=
                "    {                                                      \n"+
                        "      __node: li.sky.skyid                                 \n"+
                        "      date:                                                \n"+
                        "      {                                                    \n"+
                        "        expr: h1                                           \n"+
                        "        __label: 日期                                      \n"+
                        "      }                                                    \n"+
                        "      sn:                                                  \n"+
                        "      {                                                    \n"+
                        "                                                           \n"+
                        "        js: md5(baseUri+item.date+headers['Content-Type']);\n"+
                        "      }                                                    \n"+
                        "      weather:                                             \n"+
                        "      {                                                    \n"+
                        "        expr: p.wea                                        \n"+
                        "      }                                                    \n"+
                        "      temprature:                                          \n"+
                        "      {                                                    \n"+
                        "        expr: p.tem>i                                      \n"+
                        "      }                                                    \n"+
                        "    }                                                      \n";
        GoldSpider spider= com.xst.golddata.GoldSpider.newSpider()
                .setUrl("http://www.weather.com.cn/weather/101020100.shtml")
                .setRule(ruleContent)
                .request();
        List list=spider.extractList();
        // List<Weather> weathers=spider.extractList(Weather.class);
        // Weather weathers=spider.extractFirst(Weather.class);
        for(int i = 0 ;i<list.size();++i){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void myTest(){
        String rules = "{\n" +
                "            __node:div.articleCont\n" +
                "            title:\n" +
                "            {\n" +
                "                expr:div.title h2\n" +
                "            }\n" +
                "            date:\n" +
                "            {\n" +
                "                expr:div.artOri:matchText\n" +
                "                js: var xx = source.replace(' 来源：','');xx;\n" +
                "            }\n" +
                "            content:\n" +
                "            {\n" +
                "                expr:div.artDet\n" +
                "            }\n" +
                "            editor:\n" +
                "            {\n" +
                "                expr:div.editor\n" +
                "            }\n" +
                "        }";


        /*
        {
            __node:div.articleCont
            title:
            {
                expr:div.title h2
            }
            date:
            {
                expr:div.artOri:matchText
                js:source.replace(" 来源：","")
            }
            content:
            {
                expr:div.artDet p
            }
            editor:
            {
                expr:div.editor
            }
        }
        */

        GoldSpider spider = GoldSpider.newSpider()
                .setUrl("http://health.people.com.cn/n1/2019/0315/c14739-30977066.html")
                .setRule(rules)
                .request();
        List list = spider.extractList();
        for(int i = 0 ;i<list.size();++i){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void pageTest() {
        Integer start = 1, end = 13;
        String baseUrl = "http://health.people.com.cn/GB/408572/";
        String rules = "{\n" +
                "            __node:ul.list_02 div.newsItems\n" +
                "            title:\n" +
                "            {\n" +
                "                expr:a:matchText\n" +
                "            }\n" +
                "            date:\n" +
                "            {\n" +
                "                expr:div.n_time\n" +
                "            }\n" +
                "           url:\n" +
                "            {\n" +
                "                expr:a\n" +
                "                attr:abs:href\n" +
                "             }\n" +
                "           sn:\n" +
                "             {\n" +
                "                js: md5(baseUri + item.date + headers['Content-Type']);\n" +
                "             }\n" +
                "        }";

        /*
        {
            __node:div.newsItems;
            title:
            {
                expr:a:matchText
            }
            date:
            {
                expr:div.n_time
            }
            url:
            {
                expr:a
                attr:abs:href
            }
        }
        */

        GoldSpider spider = GoldSpider.newSpider();

        for(Integer i = start;i <= end;++i){
            spider.setUrl(baseUrl + "index" + i + ".html").setRule(rules).request();
            List list = spider.extractList();
            for(int j = 0 ;j < list.size();++j){
                System.out.println(list.get(j));
            }
        }

    }

    @Test
    public void newTest(){
        Integer start = 1, end = 4;
        String baseUrl = "http://www.china-jb.com.cn/html/shenjingkejibing/";

        String rules = "{\n" +
                "            __node:div#left div.m10\n" +
                "            title:\n" +
                "            {\n" +
                "                expr:h1.list_title a:matchText\n" +
                "            }\n" +
                "            desc:\n" +
                "            {\n" +
                "                expr:div.list_jj\n" +
                "                __showOnList: true\n" +
                "            }\n" +
                "            type:\n" +
                "            {\n" +
                "                expr:div.list_other > span:eq(0) a:matchText\n" +
                "            }\n" +
                "        }";


        /*
        {
            fields0:{
                __node:div.m10
                title: {
                    expr:
                }
            }
        }
        */


        GoldSpider spider = com.xst.golddata.GoldSpider.newSpider()
                .setUrl(baseUrl)
                .setRule(rules)
                .request();
        List list = spider.extractList();
        // List<Weather> weathers=spider.extractList(Weather.class);
        // Weather weathers=spider.extractFirst(Weather.class);
        for (Object o : list) {
            System.out.println(o);
        }
    }


    // 疾病百科
    @Test
    public void DiseaseSpider(){
        String baseUrl = "http://jbk.39.net/";

        String rules = "{\n" +
                "            __node: div.menu.menu_cur li\n" +
                "            title:{\n" +
                "                expr:a:matchText\n" +
                "            }\n" +
                "            url:{\n" +
                "                expr:a\n" +
                "                attr:abs:href\n" +
                "            }\n" +
                "           sn:{\n" +
                "                js: md5(baseUri + item.date + headers['Content-Type']);\n" +
                "            }\n" +
                "        }";

        /*
        {
            __node: div.menu.menu_cur li
            "title":{
                expr:a:matchText
            }
            "url":{
                expr:a
                attr:abs:href
            }
        }
        */

        GoldSpider spider = com.xst.golddata.GoldSpider.newSpider()
                .setUrl(baseUrl)
                .setRule(rules)
                .request();
        List list = spider.extractList();
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void DiseaseListSpider(){
        String baseUrl = "http://jbk.39.net/bw/neike_p1";

        String rules = "{\n" +
                "            __node:div.result_item\n" +
                "            name:{\n" +
                "                expr:div.result_item_top > p.result_item_top_l > a\n" +
                "                attr:title\n" +
                "            }\n" +
                "            url:{\n" +
                "                expr:div.result_item_top > p.result_item_top_l > a\n" +
                "                attr:abs:href\n" +
                "            }\n" +
                "           sn:{\n" +
                "                js: md5(baseUri + item.date + headers['Content-Type']);\n" +
                "            }\n" +
                "        }";
        GoldSpider spider = com.xst.golddata.GoldSpider.newSpider()
                .setUrl(baseUrl)
                .setRule(rules)
                .request();
        List list = spider.extractList();
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void DiseaseDetailSpider(){

        String baseUrl = "http://jbk.39.net/dx/jbzs/";

        String rules = "{\n" +
                "            __node:div.container\n" +
                "            name:{\n" +
                "                expr:div.disease h1\n" +
                "            }\n" +
                "            desc:{\n" +
                "                expr:p.introduction\n" +
                "            }\n" +
                "            isYiBao:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:eq(0) > span:eq(1)\n" +
                "            }\n" +
                "            otherName:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:eq(1) > span:eq(1)\n" +
                "            }\n" +
                "            location:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:eq(2) > span:eq(1) a\n" +
                "            }\n" +
                "            infectivity:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:eq(3) > span:eq(1)\n" +
                "            }\n" +
                "            population:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:eq(4) > span:eq(1)\n" +
                "            }\n" +
                "            symptom:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:eq(5) > span:eq(1)\n" +
                "                js:var list = (''+source).match(/title=\"(\\S*)\"/g).join(',').replace(/title=/g,'').replace(/\"/g,'');list;\n" +
                "            }\n" +
                "            concurrentDisease:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:eq(6) > span:eq(1)\n" +
                "                js:var list = (''+source).match(/title=\"(\\S*)\"/g).join(',').replace(/title=/g,'').replace(/\"/g,'');list;\n" +
                "            }\n" +
                "            department:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:eq(0) > span:eq(1)\n" +
                "                js:var list = (''+source).match(/>(\\S*)</g).join(',').replace(/</g,'').replace(/>/g,'');list;\n" +
                "            }\n" +
                "            cost:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:eq(1) > span:eq(1)\n" +
                "            }\n" +
                "            treatmentRate:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:has(span:contains(治愈率)) > span:eq(1)\n" +
                "            }\n" +
                "            treatmentCycle:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:has(span:contains(治疗周期)) > span:eq(1)\n" +
                "            }\n" +
                "            therapeuticMethod:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:has(span:contains(治疗方法)) > span:eq(1) > a:eq(0)\n" +
                "            }\n" +
                "            correlationCheck:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:has(span:contains(相关检查)) > span:eq(1)\n" +
                "                js:var list = (''+source).match(/title=\"(\\S*)\"/g).join(',').replace(/title=/g,'').replace(/\"/g,'');list;\n" +
                "            }\n" +
                "            drugs:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:has(span:contains(常用药品)) > span:eq(1)\n" +
                "                js:var list = (''+source).match(/>(\\S*)</g).join(',').replace(/</g,'').replace(/>/g,'');list;\n" +
                "            }\n" +
                "            bestTreatmentTime:{\n" +
                "                expr:div.disease_box:eq(3) > ul > li:eq(0) > span:eq(1)\n" +
                "            }\n" +
                "            visitTime:{\n" +
                "                expr:div.disease_box:eq(3) > ul > li:eq(1) > span:eq(1)\n" +
                "            }\n" +
                "            referralFrequency:{\n" +
                "                expr:div.disease_box:eq(3) > ul > li:eq(2) > span:eq(1)\n" +
                "            }\n" +
                "            preparement:{\n" +
                "                expr:div.disease_box:eq(3) > ul > li:eq(3) > span:eq(1)\n" +
                "            }\n" +
                "        }";

        /*{
            __node:div.container;
            name:{
                expr:div.disease h1
            },
            desc:{
                expr:p.introduction
            },
            shi_fou_yi_bao:{
                expr:ul.disease_basic > li:eq(0) > span:eq(1)
            }
            other_name:{
                expr:ul.disease_basic > li:eq(1) > span:eq(1)
            },
            disease_part:{
                expr:ul.disease_basic > li:eq(2) > span:eq(1) a
            },
            ganranxing:{
                expr:ul.disease_basic > li:eq(3) > span:eq(1)
            },
            population:{
                expr:ul.disease_basic > li:eq(4) > span:eq(1)
            },
            zhengzhuang:{
                expr:ul.disease_basic > li:eq(5) > span:eq(1)
                js:var list = (''+source).match(/title="(\S*)"/g).join(',').replace(/title=/g,'').replace(/"/g,'');list;
            },
            bingfajibing:{
                expr:ul.disease_basic > li:eq(6) > span:eq(1)
                js:var list = (''+source).match(/title="(\S*)"/g).join(',').replace(/title=/g,'').replace(/"/g,'');list;
            },
            jiuzhengkeshi:{
                expr:div.disease_box:eq(2) > ul > li:eq(0) > span:eq(1)
                js:var list = (''+source).match(/>(\S*)</g).join(',').replace(/</g,'').replace(/>/g,'');list;
            },
            zhiliaofeiyong:{
                expr:div.disease_box:eq(2) > ul > li:eq(1) > span:eq(1)
            }
            zhi_liao_lv:{
                expr:div.disease_box:eq(2) > ul > li:eq(2) > span:eq(1)
            }
            zhi_liao_zhou_qi:{
                expr:div.disease_box:eq(2) > ul > li:eq(3) > span:eq(1)
            }
            zhi_liao_fang_fa:{
                expr:div.disease_box:eq(2) > ul > li:eq(4) > span:eq(1) > a:eq(0)
            }
            xiang_guan_jian_cha:{
                expr:div.disease_box:eq(2) > ul > li:eq(5) > span:eq(1)
                js:var list = (''+source).match(/title="(\S*)"/g).join(',').replace(/title=/g,'').replace(/"/g,'');list;
            }
            chang_yong_yao_pin:{
                expr:div.disease_box:eq(2) > ul > li:eq(6) > span:eq(1)
                js:var list = (''+source).match(/>(\S*)</g).join(',').replace(/</g,'').replace(/>/g,'');list;
            }
            zui_jia_jiu_zheng_shi_jian:{
                expr:div.disease_box:eq(3) > ul > li:eq(0) > span:eq(1)
            }
            jiu_zheng_shi_chang:{
                expr:div.disease_box:eq(3) > ul > li:eq(1) > span:eq(1)
            }
            fu_zheng_pin_lv:{
                expr:div.disease_box:eq(3) > ul > li:eq(2) > span:eq(1)
            }
            jiu_zheng_qian_zhun_bei:{
                expr:div.disease_box:eq(3) > ul > li:eq(3) > span:eq(1)
            }
        }*/

        GoldSpider spider = com.xst.golddata.GoldSpider.newSpider()
                .setUrl(baseUrl)
                .setRule(rules)
                .request();
        List list = spider.extractList();
        for (Object o : list) {
            System.out.println(o);
        }
    }

}
