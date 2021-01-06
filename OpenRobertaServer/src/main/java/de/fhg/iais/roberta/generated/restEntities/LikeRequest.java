/*
 * This is a class GENERATED by the TransportGenerator maven plugin. DON'T MODIFY IT.
 * IF you modify it, your work may be lost: the class will be overwritten automatically
 * when the maven plugin is re-executed for any reasons.
 */
package de.fhg.iais.roberta.generated.restEntities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * the request description for the /like REST request<br>
 * <br>
 * Version: 1<br>
 * Datum: 2020-06-15
 */
public class LikeRequest extends BaseRequest {
    protected String programName;
    protected String robotName;
    protected String author;
    protected boolean like;
    protected boolean likeDefined = false;

    /**
     * the request description for the /like REST request
     */
    public static LikeRequest make() {
        return new LikeRequest();
    }

    /**
     * the request description for the /like REST request
     */
    public static LikeRequest makeFromString(String jsonS) {
        try {
            JSONObject jsonO = new JSONObject(jsonS);
            return make(jsonO);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON parse error when parsing: " + jsonS, e);
        }
    }

    /**
     * the request description for the /like REST request
     */
    public static LikeRequest makeFromProperties(String cmd, String programName, String robotName, String author, boolean like) {
        LikeRequest entity = new LikeRequest();
        entity.setCmd(cmd);
        entity.setProgramName(programName);
        entity.setRobotName(robotName);
        entity.setAuthor(author);
        entity.setLike(like);
        entity.immutable();
        return entity;
    }

    /**
     * the request description for the /like REST request
     */
    public static LikeRequest make(JSONObject jsonO) {
        return make().merge(jsonO).immutable();
    }

    /**
     * merge the properties of a JSON-object into this bean. The bean must be "under construction". The keys of the JSON-Object must be valid. The bean remains
     * "under construction".<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    @Override
    public LikeRequest merge(JSONObject jsonO) {
        try {
            for ( String key : JSONObject.getNames(jsonO) ) {
                if ( "_version".equals(key) ) {
                } else if ( "cmd".equals(key) ) {
                    setCmd(jsonO.optString(key));
                } else if ( "programName".equals(key) ) {
                    setProgramName(jsonO.getString(key));
                } else if ( "robotName".equals(key) ) {
                    setRobotName(jsonO.getString(key));
                } else if ( "author".equals(key) ) {
                    setAuthor(jsonO.getString(key));
                } else if ( "like".equals(key) ) {
                    setLike(jsonO.getBoolean(key));
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
    public LikeRequest immutable() {
        if ( this.immutable ) {
            return this;
        }
        this.immutable = true;
        return validate();
    }

    /**
     * Checks whether all required fields are set.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    private LikeRequest validate() {
        String _message = null;
        if ( !this.immutable ) {
            _message = "LikeRequest-object is already immutable: " + toString();
        }
        if ( this.programName == null ) {
            _message = "required property programName of LikeRequest-object is not set: " + toString();
        }
        if ( this.robotName == null ) {
            _message = "required property robotName of LikeRequest-object is not set: " + toString();
        }
        if ( this.author == null ) {
            _message = "required property author of LikeRequest-object is not set: " + toString();
        }
        if ( !this.likeDefined ) {
            _message = "required property like of LikeRequest-object is not set: " + toString();
        }
        if ( _message != null ) {
            this.immutable = false;
            throw new RuntimeException(_message);
        }
        return this;
    }

    /**
     * GET programName. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getProgramName() {
        if ( !this.immutable ) {
            throw new RuntimeException("no programName from an object under construction: " + toString());
        }
        return this.programName;
    }

    /**
     * SET programName. Object must be mutable.
     */
    public LikeRequest setProgramName(String programName) {
        if ( this.immutable ) {
            throw new RuntimeException("programName assigned to an immutable object: " + toString());
        }
        this.programName = programName;
        return this;
    }

    /**
     * GET robotName. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getRobotName() {
        if ( !this.immutable ) {
            throw new RuntimeException("no robotName from an object under construction: " + toString());
        }
        return this.robotName;
    }

    /**
     * SET robotName. Object must be mutable.
     */
    public LikeRequest setRobotName(String robotName) {
        if ( this.immutable ) {
            throw new RuntimeException("robotName assigned to an immutable object: " + toString());
        }
        this.robotName = robotName;
        return this;
    }

    /**
     * GET author. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getAuthor() {
        if ( !this.immutable ) {
            throw new RuntimeException("no author from an object under construction: " + toString());
        }
        return this.author;
    }

    /**
     * SET author. Object must be mutable.
     */
    public LikeRequest setAuthor(String author) {
        if ( this.immutable ) {
            throw new RuntimeException("author assigned to an immutable object: " + toString());
        }
        this.author = author;
        return this;
    }

    /**
     * GET like. Object must be immutable. Never return null or an undefined/default value.
     */
    public boolean getLike() {
        if ( !this.immutable ) {
            throw new RuntimeException("no like from an object under construction: " + toString());
        }
        return this.like;
    }

    /**
     * SET like. Object must be mutable.
     */
    public LikeRequest setLike(boolean like) {
        if ( this.immutable ) {
            throw new RuntimeException("like assigned to an immutable object: " + toString());
        }
        this.like = like;
        this.likeDefined = true;
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
            jsonO.put("programName", this.programName);
            jsonO.put("robotName", this.robotName);
            jsonO.put("author", this.author);
            jsonO.put("like", this.like);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON unparse error when unparsing: " + this, e);
        }
        return jsonO;
    }

    @Override
    public String toString() {
        return "LikeRequest [immutable="
            + this.immutable
            + ", cmd="
            + this.cmd
            + ", programName="
            + this.programName
            + ", robotName="
            + this.robotName
            + ", author="
            + this.author
            + ", like="
            + this.like
            + " ]";
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
