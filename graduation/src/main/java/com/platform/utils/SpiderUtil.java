package com.platform.utils;

import com.platform.model.DiseaseInfo;
import com.platform.model.DiseaseItem;
import com.xst.golddata.GoldSpider;

import java.util.*;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-25 14:03
 */
public class SpiderUtil {

    public static List<LinkedHashMap<String,Object>> spiderMenu(){
        String baseUrl = "http://jbk.39.net/";
        String rules = "{\n" +
                "            __node: div.menu.menu_cur li\n" +
                "            name:{\n" +
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
        GoldSpider spider = com.xst.golddata.GoldSpider.newSpider()
                .setUrl(baseUrl)
                .setRule(rules)
                .request();
        List list = spider.extractList();
        for (Object o : list) {
            System.out.println(o);
        }
        return list;
    }

    public static List<LinkedHashMap<String,Object>> spiderDiseaseList(String url,Integer start,Integer end){
        List<LinkedHashMap<String,Object>> resultLList = new ArrayList<>();
        for(Integer i = start; i <= end; ++i){
            String baseUrl = url;
            String newUrl = baseUrl.substring(0,baseUrl.length()-1) + "_p" + i;
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
                    .setUrl(newUrl)
                    .setRule(rules)
                    .request();
            List list = spider.extractList();
            resultLList.addAll(list);
            for (Object o : list) {
                System.out.println(o);
            }
        }
        return resultLList;
    }

    public static List<Map> spiderDiseaseDetail(List<DiseaseInfo> search){

        String baseUrl = "";
        String rules = "{\n" +
                "            __node:div.container\n" +
                "            name:{\n" +
                "                expr:div.disease h1\n" +
                "            }\n" +
                "            desc:{\n" +
                "                expr:p.introduction\n" +
                "            }\n" +
                "            isYiBao:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:has(span:contains(是否属于医保)) > span:eq(1)\n" +
                "            }\n" +
                "            otherName:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:has(span:contains(别名)) > span:eq(1)\n" +
                "            }\n" +
                "            location:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:has(span:contains(发病部位)) > span:eq(1) a\n" +
                "            }\n" +
                "            infectivity:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:has(span:contains(传染性)) > span:eq(1)\n" +
                "            }\n" +
                "            population:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:has(span:contains(多发人群)) > span:eq(1)\n" +
                "            }\n" +
                "            symptom:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:has(span:contains(相关症状)) > span:eq(1)\n" +
                "                js:var list = (''+source).match(/title=\"(\\S*)\"/g).join(',').replace(/title=/g,'').replace(/\"/g,'');list;\n" +
                "            }\n" +
                "            concurrentDisease:{\n" +
                "                expr:div.disease_box:eq(1) > ul > li:has(span:contains(并发疾病)) > span:eq(1)\n" +
                "                js:var list = (''+source).match(/title=\"(\\S*)\"/g).join(',').replace(/title=/g,'').replace(/\"/g,'');list;\n" +
                "            }\n" +
                "            department:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:has(span:contains(就诊科室)) > span:eq(1)\n" +
                "                js:var list = (''+source).match(/>(\\S*)</g).join(',').replace(/</g,'').replace(/>/g,'');list;\n" +
                "            }\n" +
                "            cost:{\n" +
                "                expr:div.disease_box:eq(2) > ul > li:has(span:contains(治疗费用)) > span:eq(1)\n" +
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
                "                js: if(!source){source=item.correlationCheck}; var list = (''+source).match(/>(\\S*)</g).join(',').replace(/</g,'').replace(/>/g,'');list;\n" +
                "            }\n" +
                "            bestTreatmentTime:{\n" +
                "                expr:div.disease_box:eq(3) > ul > li:has(span:contains(最佳就诊时间)) > span:eq(1)\n" +
                "            }\n" +
                "            visitTime:{\n" +
                "                expr:div.disease_box:eq(3) > ul > li:has(span:contains(就诊时长)) > span:eq(1)\n" +
                "            }\n" +
                "            referralFrequency:{\n" +
                "                expr:div.disease_box:eq(3) > ul > li:has(span:contains(复诊频率)) > span:eq(1)\n" +
                "            }\n" +
                "            preparement:{\n" +
                "                expr:div.disease_box:eq(3) > ul > li:has(span:contains(就诊前准备)) > span:eq(1)\n" +
                "            }\n" +
                "        }";

        GoldSpider spider = com.xst.golddata.GoldSpider.newSpider();
        List<Map> result = new ArrayList<>();
        for(DiseaseInfo item : search){
            baseUrl = item.getUrl();
            spider.setUrl(baseUrl).setRule(rules).request();
            List<Map> list = spider.extractList();
            for(Map o : list){
                o.put("id",item.getId());
                System.out.println(o);
            }
            result.addAll(list);
        }
        return result;
    }
}
