package com.platform.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-25 13:23
 */
public class DiseaseInfo {

    private Integer id;
    private Integer diseaseId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Integer status;
    private String url;//来源
    private Integer type;//分类
    private String typeName;//类名
    private String name;//病名
    private String desc;//简介
    private String isYiBao;//是否属于医保
    private String otherName;//别名
    private String location;//发病部位
    private String infectivity;//感染性
    private String population;//感染人群
    private String symptom;//症状
    private String concurrentDisease;//并发疾病
    private String department;//就诊科室
    private String cost;//治疗费用
    private String treatmentRate;//治疗率
    private String treatmentCycle;//治疗周期
    private String therapeuticMethod;//治疗方法
    private String correlationCheck;//相关检查
    private String drugs;//常用药品
    private String bestTreatmentTime;//最佳就诊时间
    private String visitTime;//就诊时长
    private String referralFrequency;//复诊频率
    private String preparement;//就诊前准备

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIsYiBao() {
        return isYiBao;
    }

    public void setIsYiBao(String isYiBao) {
        this.isYiBao = isYiBao;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInfectivity() {
        return infectivity;
    }

    public void setInfectivity(String infectivity) {
        this.infectivity = infectivity;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getConcurrentDisease() {
        return concurrentDisease;
    }

    public void setConcurrentDisease(String concurrentDisease) {
        this.concurrentDisease = concurrentDisease;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTreatmentRate() {
        return treatmentRate;
    }

    public void setTreatmentRate(String treatmentRate) {
        this.treatmentRate = treatmentRate;
    }

    public String getTreatmentCycle() {
        return treatmentCycle;
    }

    public void setTreatmentCycle(String treatmentCycle) {
        this.treatmentCycle = treatmentCycle;
    }

    public String getTherapeuticMethod() {
        return therapeuticMethod;
    }

    public void setTherapeuticMethod(String therapeuticMethod) {
        this.therapeuticMethod = therapeuticMethod;
    }

    public String getCorrelationCheck() {
        return correlationCheck;
    }

    public void setCorrelationCheck(String correlationCheck) {
        this.correlationCheck = correlationCheck;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getBestTreatmentTime() {
        return bestTreatmentTime;
    }

    public void setBestTreatmentTime(String bestTreatmentTime) {
        this.bestTreatmentTime = bestTreatmentTime;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getReferralFrequency() {
        return referralFrequency;
    }

    public void setReferralFrequency(String referralFrequency) {
        this.referralFrequency = referralFrequency;
    }

    public String getPreparement() {
        return preparement;
    }

    public void setPreparement(String preparement) {
        this.preparement = preparement;
    }
}
