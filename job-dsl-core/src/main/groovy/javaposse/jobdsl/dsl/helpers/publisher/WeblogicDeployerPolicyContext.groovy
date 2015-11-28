package javaposse.jobdsl.dsl.helpers.publisher

import javaposse.jobdsl.dsl.Context

import static javaposse.jobdsl.dsl.helpers.publisher.WeblogicDeployerPolicyContext.WeblogicDeploymentPolicies.DEPLOYMENT_TIMER
import static javaposse.jobdsl.dsl.helpers.publisher.WeblogicDeployerPolicyContext.WeblogicDeploymentPolicies.LEGACY_CODE
import static javaposse.jobdsl.dsl.helpers.publisher.WeblogicDeployerPolicyContext.WeblogicDeploymentPolicies.REMOTE_HOST
import static javaposse.jobdsl.dsl.helpers.publisher.WeblogicDeployerPolicyContext.WeblogicDeploymentPolicies.SCM_CHANGE
import static javaposse.jobdsl.dsl.helpers.publisher.WeblogicDeployerPolicyContext.WeblogicDeploymentPolicies.UPSTREAM
import static javaposse.jobdsl.dsl.helpers.publisher.WeblogicDeployerPolicyContext.WeblogicDeploymentPolicies.USER
import static javaposse.jobdsl.dsl.helpers.publisher.WeblogicDeployerPolicyContext.WeblogicDeploymentPolicies.USER_ID

/**
 * DSL Support for the weblogic-deployment-plugin's deployment policies subsection.
 */
class WeblogicDeployerPolicyContext implements Context {

    /**
     * Enumeration of available deployment policies.
     */
    static enum WeblogicDeploymentPolicies {

        /**
         * Legacy code started this job.  No cause information is available.
         */
        LEGACY_CODE('hudson.model.Cause\\\\\$LegacyCodeCause'),

        /**
         * Started by user.
         */
        USER('hudson.model.Cause\\\\\$UserCause'),

        /**
         * Started by user.
         */
        USER_ID('hudson.model.Cause\\\\\$UserIdCause'),

        /**
         * Started by remote host.
         */
        REMOTE_HOST('hudson.model.Cause\\\\\$RemoteCause'),

        /**
         * Built after other projects are built or whenever a SNAPSHOT dependency is built.
         */
        UPSTREAM('hudson.model.Cause\\\\\$UpstreamCause'),

        /**
         * Started by deployment timer.
         */
        DEPLOYMENT_TIMER('org.jenkinsci.plugins.deploy.weblogic.trigger.DeploymentTrigger\\\\\$DeploymentTriggerCause'),

        /**
         * Started by an SCM change.
         */
        SCM_CHANGE('hudson.triggers.SCMTrigger\\\\\$SCMTriggerCause'),

        private final String stringRepresentation

        WeblogicDeploymentPolicies(String stringRepresentation) {
            this.stringRepresentation = stringRepresentation
        }

        @Override
        String toString() {
            this.stringRepresentation
        }
    }

    /**
     * Deployment policy.
     */
    List<String> deploymentPolicies = []

    /**
     * Legacy code started this job.  No cause information is available.
     */
    void legacyCode() {
        this.deploymentPolicies.add(LEGACY_CODE)
    }

    /**
     * Started by user.
     */
    void user() {
        this.deploymentPolicies.add(USER)
    }

    /**
     * Started by user.
     */
    void userId() {
        this.deploymentPolicies.add(USER_ID)
    }

    /**
     * Started by remote host.
     */
    void remoteHost() {
        this.deploymentPolicies.add(REMOTE_HOST)
    }

    /**
     * Built after other projects are built or whenever a SNAPSHOT dependency is built.
     */
    void upstream() {
        this.deploymentPolicies.add(UPSTREAM)
    }

    /**
     * Started by deployment timer.
     */
    void deploymentTimer() {
        this.deploymentPolicies.add(DEPLOYMENT_TIMER)
    }

    /**
     * Started by an SCM change.
     */
    void scmChange() {
        this.deploymentPolicies.add(SCM_CHANGE)
    }
}
