package cn.bjd.platform.elastic.api.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 工商企业表
 */
public class Etp implements Serializable {
    /**
     * 企业id
     */
    private String id;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 所属行业  清洗出来的
     */
    private String industry;

    /**
     * 行业id   清洗出来的
     */
    private Integer industryId;

    /**
     * 统一社会信用代码
     */
    private String creditCode;

    /**
     * 法人代表
     */
    private String legalRep;

    /**
     * 登记机关
     */
    private String regOffice;

    /**
     * 成立日期
     */
    private Date regDate;

    /**
     * 注销原因（注销公司才能有该字段的属性）
     */
    private String canRea;

    /**
     * 是否注销
     */
    private String isCancel;

    /**
     * 注销日期
     */
    private Date canDate;


    /**
     *
     */
    private String unIsCid;

    /**
     * 公司类型
     */
    private String type;

    /**
     * 注册资本（万）
     */
    private String regCapital;

    /**
     * 营业期限自
     */
    private Date businessStart;

    /**
     * 营业期限至
     */
    private Date businessFinish;

    /**
     * 核准日期
     */
    private Date checkDate;

    /**
     * 企业类型
     */
    private String entType;

    /**
     * 登记状态
     */
    private String regStateCN;

    /**
     * 注册非中文
     */
    private String regState;


    private String state;
    /**
     * 住所
     */
    private String address;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 工商总局的pid
     */
    private String priPid;

    /**
     * 单位（人民币 或者美元）
     */
    private String regCapCurCn;

    /**
     * 公告开始日期
     */
    private Date noticeFom;

    /**
     * 公告结束日期
     */
    private Date noticeTo;

    /**
     * 吊销日期
     */
    private Date revDate;


    /**
     * 法定代表人名称
     */
    private String nameLike;


    /**
     * 补充 企业名称
     */
    private String entNameHight;

    /**
     * counry的code
     */
    private String countryCode;

    /**
     * 新增的省份名称
     */
    private String addProvince;

    /**
     * C_STATE
     */
    private String cState;

    /**
     * 行业
     */
    private String industryPhy;

    /**
     * city code
     */
    private String cityCode;


    /**
     * 省份code
     */
    private String provinceCode;

    /**
     *ISMOVE
     */
    private String isMove;

    /**
     * 企业类型
     */
    private String pripType;

    /**
     *todo
     */
    private String isButton;

    /**
     * //todo
     */
    private String revbBasis;

    /**
     * todo
     */
    private String compformCn;

    /**
     *
     */
    private String cOutStatus;
    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 插入时间
     */
    private Date insDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * Gets compformCn
     *
     * @return value of compformCn
     */
    public String getCompformCn() {
        return compformCn;
    }

    /**
     * @param compformCn
     */
    public void setCompformCn(String compformCn) {
        this.compformCn = compformCn;
    }

    /**
     * Gets canDate
     *
     * @return value of canDate
     */
    public Date getCanDate() {
        return canDate;
    }

    /**
     * @param canDate
     */
    public void setCanDate(Date canDate) {
        this.canDate = canDate;
    }

    /**
     * Gets revbBasis
     *
     * @return value of revbBasis
     */
    public String getRevbBasis() {
        return revbBasis;
    }

    /**
     * @param revbBasis
     */
    public void setRevbBasis(String revbBasis) {
        this.revbBasis = revbBasis;
    }

    /**
     * Gets isButton
     *
     * @return value of isButton
     */
    public String getIsButton() {
        return isButton;
    }

    /**
     * @param isButton
     */
    public void setIsButton(String isButton) {
        this.isButton = isButton;
    }

    /**
     * Gets pripType
     *
     * @return value of pripType
     */
    public String getPripType() {
        return pripType;
    }

    /**
     * @param pripType
     */
    public void setPripType(String pripType) {
        this.pripType = pripType;
    }

    /**
     * Gets isMove
     *
     * @return value of isMove
     */
    public String getIsMove() {
        return isMove;
    }

    /**
     * @param isMove
     */
    public void setIsMove(String isMove) {
        this.isMove = isMove;
    }

    /**
     * Gets provinceCode
     *
     * @return value of provinceCode
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * Gets regStateCN
     *
     * @return value of regStateCN
     */
    public String getRegStateCN() {
        return regStateCN;
    }

    /**
     * @param regStateCN
     */
    public void setRegStateCN(String regStateCN) {
        this.regStateCN = regStateCN;
    }

    /**
     * Gets industryPhy
     *
     * @return value of industryPhy
     */
    public String getIndustryPhy() {
        return industryPhy;
    }

    /**
     * @param industryPhy
     */
    public void setIndustryPhy(String industryPhy) {
        this.industryPhy = industryPhy;
    }

    /**
     * Gets cState
     *
     * @return value of cState
     */
    public String getcState() {
        return cState;
    }

    /**
     * @param cState
     */
    public void setcState(String cState) {
        this.cState = cState;
    }

    /**
     * Gets addProvince
     *
     * @return value of addProvince
     */
    public String getAddProvince() {
        return addProvince;
    }

    /**
     * @param addProvince
     */
    public void setAddProvince(String addProvince) {
        this.addProvince = addProvince;
    }

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets entName
     *
     * @return value of entName
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * Gets industry
     *
     * @return value of industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * @param industry
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * Gets industryId
     *
     * @return value of industryId
     */
    public Integer getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId
     */
    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    /**
     * Gets creditCode
     *
     * @return value of creditCode
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * @param creditCode
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    /**
     * Gets legalRep
     *
     * @return value of legalRep
     */
    public String getLegalRep() {
        return legalRep;
    }

    /**
     * @param legalRep
     */
    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    /**
     * Gets regOffice
     *
     * @return value of regOffice
     */
    public String getRegOffice() {
        return regOffice;
    }

    /**
     * @param regOffice
     */
    public void setRegOffice(String regOffice) {
        this.regOffice = regOffice;
    }

    /**
     * Gets regDate
     *
     * @return value of regDate
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * @param regDate
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * Gets canRea
     *
     * @return value of canRea
     */
    public String getCanRea() {
        return canRea;
    }

    /**
     * @param canRea
     */
    public void setCanRea(String canRea) {
        this.canRea = canRea;
    }

    /**
     * Gets isCancel
     *
     * @return value of isCancel
     */
    public String getIsCancel() {
        return isCancel;
    }

    /**
     * @param isCancel
     */
    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    /**
     * Gets unIsCid
     *
     * @return value of unIsCid
     */
    public String getUnIsCid() {
        return unIsCid;
    }

    /**
     * @param unIsCid
     */
    public void setUnIsCid(String unIsCid) {
        this.unIsCid = unIsCid;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets regCapital
     *
     * @return value of regCapital
     */
    public String getRegCapital() {
        return regCapital;
    }

    /**
     * @param regCapital
     */
    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    /**
     * Gets businessStart
     *
     * @return value of businessStart
     */
    public Date getBusinessStart() {
        return businessStart;
    }

    /**
     * @param businessStart
     */
    public void setBusinessStart(Date businessStart) {
        this.businessStart = businessStart;
    }

    /**
     * Gets businessFinish
     *
     * @return value of businessFinish
     */
    public Date getBusinessFinish() {
        return businessFinish;
    }

    /**
     * @param businessFinish
     */
    public void setBusinessFinish(Date businessFinish) {
        this.businessFinish = businessFinish;
    }

    /**
     * Gets checkDate
     *
     * @return value of checkDate
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * @param checkDate
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * Gets entType
     *
     * @return value of entType
     */
    public String getEntType() {
        return entType;
    }

    /**
     * @param entType
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * Gets regState
     *
     * @return value of regState
     */
    public String getRegState() {
        return regState;
    }

    /**
     * @param regState
     */
    public void setRegState(String regState) {
        this.regState = regState;
    }

    /**
     * Gets address
     *
     * @return value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets businessScope
     *
     * @return value of businessScope
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * @param businessScope
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    /**
     * Gets priPid
     *
     * @return value of priPid
     */
    public String getPriPid() {
        return priPid;
    }

    /**
     * @param priPid
     */
    public void setPriPid(String priPid) {
        this.priPid = priPid;
    }

    /**
     * Gets regCapCurCn
     *
     * @return value of regCapCurCn
     */
    public String getRegCapCurCn() {
        return regCapCurCn;
    }

    /**
     * @param regCapCurCn
     */
    public void setRegCapCurCn(String regCapCurCn) {
        this.regCapCurCn = regCapCurCn;
    }

    /**
     * Gets noticeFom
     *
     * @return value of noticeFom
     */
    public Date getNoticeFom() {
        return noticeFom;
    }

    /**
     * @param noticeFom
     */
    public void setNoticeFom(Date noticeFom) {
        this.noticeFom = noticeFom;
    }

    /**
     * Gets noticeTo
     *
     * @return value of noticeTo
     */
    public Date getNoticeTo() {
        return noticeTo;
    }

    /**
     * @param noticeTo
     */
    public void setNoticeTo(Date noticeTo) {
        this.noticeTo = noticeTo;
    }

    /**
     * Gets revDate
     *
     * @return value of revDate
     */
    public Date getRevDate() {
        return revDate;
    }

    /**
     * @param revDate
     */
    public void setRevDate(Date revDate) {
        this.revDate = revDate;
    }

    /**
     * Gets nameLike
     *
     * @return value of nameLike
     */
    public String getNameLike() {
        return nameLike;
    }

    /**
     * @param nameLike
     */
    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    /**
     * Gets province
     *
     * @return value of province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets city
     *
     * @return value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets area
     *
     * @return value of area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Gets lng
     *
     * @return value of lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * Gets lat
     *
     * @return value of lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * Gets version
     *
     * @return value of version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Gets insDate
     *
     * @return value of insDate
     */
    public Date getInsDate() {
        return insDate;
    }

    /**
     * @param insDate
     */
    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    /**
     * Gets updateDate
     *
     * @return value of updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets entNameHight
     *
     * @return value of entNameHight
     */
    public String getEntNameHight() {
        return entNameHight;
    }

    /**
     * @param entNameHight
     */
    public void setEntNameHight(String entNameHight) {
        this.entNameHight = entNameHight;
    }

    /**
     * Gets countryCode
     *
     * @return value of countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets cityCode
     *
     * @return value of cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode ;
    }

    /**
     * Gets state
     *
     * @return value of state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets cOutStatus
     *
     * @return value of cOutStatus
     */
    public String getcOutStatus() {
        return cOutStatus;
    }

    /**
     * @param cOutStatus
     */
    public void setcOutStatus(String cOutStatus) {
        this.cOutStatus = cOutStatus;
    }
}
