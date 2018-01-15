package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

public class SysDepartment extends DataEntity {
    private static final long serialVersionUID = 1L;


    private String parentId;

    private String parentIds;

    private String name;

    private String type;

    private String address;

    private Boolean enabled;

    private String remarks;

    private String master;

    private String primaryPerson;

    private String deputyPerson;

    private Integer level = 0;

    private List<SysDepartment> children = new ArrayList<>();

    public Integer getLevel() {

        String pIds = getParentIds();
        if(StringUtils.isNotBlank(pIds)&&pIds.contains(",")){
            String[] ids = pIds.split(",");
            if(ids.length>0){
                level = ids.length-1;
            }
        }

        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<SysDepartment> getChildren() {
        return children;
    }

    public void setChildren(List<SysDepartment> children) {
        this.children = children;
    }

    /**
     * 添加子节点
     *
     * @param node 菜单节点
     */
    public void addChild(SysDepartment node) {
        this.children.add(node);
    }

    public SysDepartment() {
        super();
    }

    public SysDepartment(String id) {
        super(id);
    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Length(min = 1, max = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Length(min = 0, max = 255)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getPrimaryPerson() {
        return primaryPerson;
    }

    public void setPrimaryPerson(String primaryPerson) {
        this.primaryPerson = primaryPerson;
    }

    public String getDeputyPerson() {
        return deputyPerson;
    }

    public void setDeputyPerson(String deputyPerson) {
        this.deputyPerson = deputyPerson;
    }
}