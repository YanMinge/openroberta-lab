/*
 * This is a class GENERATED by the TransportGenerator maven plugin. DON'T MODIFY IT.
 * IF you modify it, your work may be lost: the class will be overwritten automatically
 * when the maven plugin is re-executed for any reasons.
 */
package de.fhg.iais.roberta.generated.restEntities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * the request description for the /userGroup/deleteUserGroups REST request<br>
 * <br>
 * Version: 1<br>
 * Datum: 2020-06-15
 */
public class UserGroupsRequest extends BaseRequest {
    protected List<String> groupNames;

    /**
     * the request description for the /userGroup/deleteUserGroups REST request
     */
    public static UserGroupsRequest make() {
        return new UserGroupsRequest();
    }

    /**
     * the request description for the /userGroup/deleteUserGroups REST request
     */
    public static UserGroupsRequest makeFromString(String jsonS) {
        try {
            JSONObject jsonO = new JSONObject(jsonS);
            return make(jsonO);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON parse error when parsing: " + jsonS, e);
        }
    }

    /**
     * the request description for the /userGroup/deleteUserGroups REST request
     */
    public static UserGroupsRequest makeFromProperties(String cmd, List<String> groupNames) {
        UserGroupsRequest entity = new UserGroupsRequest();
        entity.setCmd(cmd);
        entity.setGroupNames(groupNames);
        entity.immutable();
        return entity;
    }

    /**
     * the request description for the /userGroup/deleteUserGroups REST request
     */
    public static UserGroupsRequest make(JSONObject jsonO) {
        return make().merge(jsonO).immutable();
    }

    /**
     * merge the properties of a JSON-object into this bean. The bean must be "under construction". The keys of the JSON-Object must be valid. The bean remains
     * "under construction".<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    @Override
    public UserGroupsRequest merge(JSONObject jsonO) {
        try {
            for ( String key : JSONObject.getNames(jsonO) ) {
                if ( "_version".equals(key) ) {
                } else if ( "cmd".equals(key) ) {
                    setCmd(jsonO.optString(key));
                } else if ( "groupNames".equals(key) ) {
                    JSONArray array = jsonO.optJSONArray(key);
                    if ( array != null && array.length() > 0 ) {
                        for ( int i = 0; i < array.length(); i++ ) {
                            addGroupNames(array.getString(i));
                        }
                    } else {
                        setGroupNames(new ArrayList<String>());
                    }
                } else {
                    throw new RuntimeException("JSON parse error. Found invalid key: " + key + " in " + jsonO);
                }
            }
            return this;
        } catch ( Exception e ) {
            throw new RuntimeException("JSON parse / casting error when parsing: " + jsonO, e);
        }
    }

    /**
     * moves a bean from state "under construction" to state "immutable".<br>
     * Checks whether all required fields are set. All lists are made immutable.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    @Override
    public UserGroupsRequest immutable() {
        if ( this.immutable ) {
            return this;
        }
        this.immutable = true;
        this.groupNames = (this.groupNames != null) ? Collections.unmodifiableList(this.groupNames) : null;
        return validate();
    }

    /**
     * Checks whether all required fields are set.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    private UserGroupsRequest validate() {
        String _message = null;
        if ( !this.immutable ) {
            _message = "UserGroupsRequest-object is already immutable: " + toString();
        }
        if ( this.groupNames == null ) {
            _message = "required property groupNames of UserGroupsRequest-object is not set: " + toString();
        }
        if ( _message != null ) {
            this.immutable = false;
            throw new RuntimeException(_message);
        }
        return this;
    }

    /**
     * GET groupNames. Object must be immutable. Never return null or an undefined/default value.
     */
    public List<String> getGroupNames() {
        if ( !this.immutable ) {
            throw new RuntimeException("no groupNames from an object under construction: " + toString());
        }
        return this.groupNames;
    }

    /**
     * SET groupNames. Object must be mutable.
     */
    public UserGroupsRequest setGroupNames(List<String> groupNames) {
        if ( this.immutable ) {
            throw new RuntimeException("groupNames assigned to an immutable object: " + toString());
        }
        if ( this.groupNames == null ) {
            this.groupNames = new ArrayList<String>();
        }
        this.groupNames.addAll(groupNames);
        return this;
    }

    /**
     * ADD groupNames. Object must be mutable.
     */
    public UserGroupsRequest addGroupNames(String groupNames) {
        if ( this.immutable ) {
            throw new RuntimeException("groupNames assigned to an immutable object: " + toString());
        }
        if ( this.groupNames == null ) {
            this.groupNames = new ArrayList<String>();
        }
        this.groupNames.add(groupNames);
        return this;
    }

    /**
     * ADD ALL groupNames. Object must be mutable.
     */
    public UserGroupsRequest addAllGroupNames(List<String> groupNames) {
        if ( this.immutable ) {
            throw new RuntimeException("groupNames assigned to an immutable object: " + toString());
        }
        if ( this.groupNames == null ) {
            this.groupNames = new ArrayList<String>();
        }
        this.groupNames.addAll(groupNames);
        return this;
    }

    /**
     * generates a JSON-object from an immutable bean.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    @Override
    public JSONObject toJson() {
        if ( !this.immutable ) {
            throw new RuntimeException("no JSON from an object under construction: " + toString());
        }
        JSONObject jsonO = new JSONObject();
        try {
            jsonO.put("_version", "1");
            if ( this.cmd != null ) {
                jsonO.put("cmd", this.cmd);
            }
            {
                JSONArray array = new JSONArray();
                for ( String item : this.groupNames ) {
                    array.put(item);
                }
                jsonO.put("groupNames", array);
            }
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON unparse error when unparsing: " + this, e);
        }
        return jsonO;
    }

    @Override
    public String toString() {
        return "UserGroupsRequest [immutable=" + this.immutable + ", cmd=" + this.cmd + ", groupNames=" + this.groupNames + " ]";
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("no hashCode from transport beans!");
    }

    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("no equals from transport beans!");
    }

}
