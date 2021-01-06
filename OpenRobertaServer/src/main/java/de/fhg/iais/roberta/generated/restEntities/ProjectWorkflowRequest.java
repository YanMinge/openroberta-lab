/*
 * This is a class GENERATED by the TransportGenerator maven plugin. DON'T MODIFY IT.
 * IF you modify it, your work may be lost: the class will be overwritten automatically
 * when the maven plugin is re-executed for any reasons.
 */
package de.fhg.iais.roberta.generated.restEntities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * the request description for the /projectWorkflow/* REST request<br>
 * <br>
 * Version: 1<br>
 * Datum: 2020-06-15
 */
public class ProjectWorkflowRequest extends BaseRequest {
    protected String programName;
    protected String configurationName;
    protected String progXML;
    protected String confXML;
    protected String SSID;
    protected String password;
    protected String language;
    protected String robot;

    /**
     * the request description for the /projectWorkflow/* REST request
     */
    public static ProjectWorkflowRequest make() {
        return new ProjectWorkflowRequest();
    }

    /**
     * the request description for the /projectWorkflow/* REST request
     */
    public static ProjectWorkflowRequest makeFromString(String jsonS) {
        try {
            JSONObject jsonO = new JSONObject(jsonS);
            return make(jsonO);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON parse error when parsing: " + jsonS, e);
        }
    }

    /**
     * the request description for the /projectWorkflow/* REST request
     */
    public static ProjectWorkflowRequest makeFromProperties(
        String cmd,
        String programName,
        String configurationName,
        String progXML,
        String confXML,
        String SSID,
        String password,
        String language,
        String robot) {
        ProjectWorkflowRequest entity = new ProjectWorkflowRequest();
        entity.setCmd(cmd);
        entity.setProgramName(programName);
        entity.setConfigurationName(configurationName);
        entity.setProgXML(progXML);
        entity.setConfXML(confXML);
        entity.setSSID(SSID);
        entity.setPassword(password);
        entity.setLanguage(language);
        entity.setRobot(robot);
        entity.immutable();
        return entity;
    }

    /**
     * the request description for the /projectWorkflow/* REST request
     */
    public static ProjectWorkflowRequest make(JSONObject jsonO) {
        return make().merge(jsonO).immutable();
    }

    /**
     * merge the properties of a JSON-object into this bean. The bean must be "under construction". The keys of the JSON-Object must be valid. The bean remains
     * "under construction".<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    @Override
    public ProjectWorkflowRequest merge(JSONObject jsonO) {
        try {
            for ( String key : JSONObject.getNames(jsonO) ) {
                if ( "_version".equals(key) ) {
                } else if ( "cmd".equals(key) ) {
                    setCmd(jsonO.optString(key));
                } else if ( "programName".equals(key) ) {
                    setProgramName(jsonO.getString(key));
                } else if ( "configurationName".equals(key) ) {
                    setConfigurationName(jsonO.optString(key));
                } else if ( "progXML".equals(key) ) {
                    setProgXML(jsonO.getString(key));
                } else if ( "confXML".equals(key) ) {
                    setConfXML(jsonO.optString(key));
                } else if ( "SSID".equals(key) ) {
                    setSSID(jsonO.optString(key));
                } else if ( "password".equals(key) ) {
                    setPassword(jsonO.optString(key));
                } else if ( "language".equals(key) ) {
                    setLanguage(jsonO.optString(key));
                } else if ( "robot".equals(key) ) {
                    setRobot(jsonO.optString(key));
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
    public ProjectWorkflowRequest immutable() {
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
    private ProjectWorkflowRequest validate() {
        String _message = null;
        if ( !this.immutable ) {
            _message = "ProjectWorkflowRequest-object is already immutable: " + toString();
        }
        if ( this.programName == null ) {
            _message = "required property programName of ProjectWorkflowRequest-object is not set: " + toString();
        }
        if ( this.progXML == null ) {
            _message = "required property progXML of ProjectWorkflowRequest-object is not set: " + toString();
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
    public ProjectWorkflowRequest setProgramName(String programName) {
        if ( this.immutable ) {
            throw new RuntimeException("programName assigned to an immutable object: " + toString());
        }
        this.programName = programName;
        return this;
    }

    /**
     * GET configurationName. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getConfigurationName() {
        if ( !this.immutable ) {
            throw new RuntimeException("no configurationName from an object under construction: " + toString());
        }
        return this.configurationName;
    }

    /**
     * is the property defined? The property maybe undefined as it is not a required property
     *
     * @return true if the property is defined (has been set)
     */
    public boolean configurationNameDefined() {
        return this.configurationName != null;
    }

    /**
     * SET configurationName. Object must be mutable.
     */
    public ProjectWorkflowRequest setConfigurationName(String configurationName) {
        if ( this.immutable ) {
            throw new RuntimeException("configurationName assigned to an immutable object: " + toString());
        }
        this.configurationName = configurationName;
        return this;
    }

    /**
     * GET progXML. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getProgXML() {
        if ( !this.immutable ) {
            throw new RuntimeException("no progXML from an object under construction: " + toString());
        }
        return this.progXML;
    }

    /**
     * SET progXML. Object must be mutable.
     */
    public ProjectWorkflowRequest setProgXML(String progXML) {
        if ( this.immutable ) {
            throw new RuntimeException("progXML assigned to an immutable object: " + toString());
        }
        this.progXML = progXML;
        return this;
    }

    /**
     * GET confXML. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getConfXML() {
        if ( !this.immutable ) {
            throw new RuntimeException("no confXML from an object under construction: " + toString());
        }
        return this.confXML;
    }

    /**
     * is the property defined? The property maybe undefined as it is not a required property
     *
     * @return true if the property is defined (has been set)
     */
    public boolean confXMLDefined() {
        return this.confXML != null;
    }

    /**
     * SET confXML. Object must be mutable.
     */
    public ProjectWorkflowRequest setConfXML(String confXML) {
        if ( this.immutable ) {
            throw new RuntimeException("confXML assigned to an immutable object: " + toString());
        }
        this.confXML = confXML;
        return this;
    }

    /**
     * GET SSID. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getSSID() {
        if ( !this.immutable ) {
            throw new RuntimeException("no SSID from an object under construction: " + toString());
        }
        return this.SSID;
    }

    /**
     * is the property defined? The property maybe undefined as it is not a required property
     *
     * @return true if the property is defined (has been set)
     */
    public boolean SSIDDefined() {
        return this.SSID != null;
    }

    /**
     * SET SSID. Object must be mutable.
     */
    public ProjectWorkflowRequest setSSID(String SSID) {
        if ( this.immutable ) {
            throw new RuntimeException("SSID assigned to an immutable object: " + toString());
        }
        this.SSID = SSID;
        return this;
    }

    /**
     * GET password. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getPassword() {
        if ( !this.immutable ) {
            throw new RuntimeException("no password from an object under construction: " + toString());
        }
        return this.password;
    }

    /**
     * is the property defined? The property maybe undefined as it is not a required property
     *
     * @return true if the property is defined (has been set)
     */
    public boolean passwordDefined() {
        return this.password != null;
    }

    /**
     * SET password. Object must be mutable.
     */
    public ProjectWorkflowRequest setPassword(String password) {
        if ( this.immutable ) {
            throw new RuntimeException("password assigned to an immutable object: " + toString());
        }
        this.password = password;
        return this;
    }

    /**
     * GET language. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getLanguage() {
        if ( !this.immutable ) {
            throw new RuntimeException("no language from an object under construction: " + toString());
        }
        return this.language;
    }

    /**
     * is the property defined? The property maybe undefined as it is not a required property
     *
     * @return true if the property is defined (has been set)
     */
    public boolean languageDefined() {
        return this.language != null;
    }

    /**
     * SET language. Object must be mutable.
     */
    public ProjectWorkflowRequest setLanguage(String language) {
        if ( this.immutable ) {
            throw new RuntimeException("language assigned to an immutable object: " + toString());
        }
        this.language = language;
        return this;
    }

    /**
     * GET robot. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getRobot() {
        if ( !this.immutable ) {
            throw new RuntimeException("no robot from an object under construction: " + toString());
        }
        return this.robot;
    }

    /**
     * is the property defined? The property maybe undefined as it is not a required property
     *
     * @return true if the property is defined (has been set)
     */
    public boolean robotDefined() {
        return this.robot != null;
    }

    /**
     * SET robot. Object must be mutable.
     */
    public ProjectWorkflowRequest setRobot(String robot) {
        if ( this.immutable ) {
            throw new RuntimeException("robot assigned to an immutable object: " + toString());
        }
        this.robot = robot;
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
            if ( this.configurationName != null ) {
                jsonO.put("configurationName", this.configurationName);
            }
            jsonO.put("progXML", this.progXML);
            if ( this.confXML != null ) {
                jsonO.put("confXML", this.confXML);
            }
            if ( this.SSID != null ) {
                jsonO.put("SSID", this.SSID);
            }
            if ( this.password != null ) {
                jsonO.put("password", this.password);
            }
            if ( this.language != null ) {
                jsonO.put("language", this.language);
            }
            if ( this.robot != null ) {
                jsonO.put("robot", this.robot);
            }
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON unparse error when unparsing: " + this, e);
        }
        return jsonO;
    }

    @Override
    public String toString() {
        return "ProjectWorkflowRequest [immutable="
            + this.immutable
            + ", cmd="
            + this.cmd
            + ", programName="
            + this.programName
            + ", configurationName="
            + this.configurationName
            + ", progXML="
            + this.progXML
            + ", confXML="
            + this.confXML
            + ", SSID="
            + this.SSID
            + ", password="
            + this.password
            + ", language="
            + this.language
            + ", robot="
            + this.robot
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
