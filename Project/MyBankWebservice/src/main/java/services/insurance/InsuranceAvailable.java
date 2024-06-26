//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2024.04.05 at 04:36:12 PM IST
//


package services.insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insuranceAvailable complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="insuranceAvailable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="insuranceId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="insuranceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="insuranceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="insuranceKeyBenefits" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="insuranceLifetime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insuranceAvailable", propOrder = {
        "insuranceId",
        "insuranceType",
        "insuranceName",
        "insuranceKeyBenefits",
        "insuranceLifetime"
})
public class InsuranceAvailable {

    protected int insuranceId;
    @XmlElement(required = true)
    protected String insuranceType;
    @XmlElement(required = true)
    protected String insuranceName;
    @XmlElement(required = true)
    protected String insuranceKeyBenefits;
    protected int insuranceLifetime;

    /**
     * Gets the value of the insuranceId property.
     *
     */
    public int getInsuranceId() {
        return insuranceId;
    }

    /**
     * Sets the value of the insuranceId property.
     *
     */
    public void setInsuranceId(int value) {
        this.insuranceId = value;
    }

    /**
     * Gets the value of the insuranceType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInsuranceType() {
        return insuranceType;
    }

    /**
     * Sets the value of the insuranceType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInsuranceType(String value) {
        this.insuranceType = value;
    }

    /**
     * Gets the value of the insuranceName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInsuranceName() {
        return insuranceName;
    }

    /**
     * Sets the value of the insuranceName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInsuranceName(String value) {
        this.insuranceName = value;
    }

    /**
     * Gets the value of the insuranceKeyBenefits property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInsuranceKeyBenefits() {
        return insuranceKeyBenefits;
    }

    /**
     * Sets the value of the insuranceKeyBenefits property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInsuranceKeyBenefits(String value) {
        this.insuranceKeyBenefits = value;
    }

    /**
     * Gets the value of the insuranceLifetime property.
     *
     */
    public int getInsuranceLifetime() {
        return insuranceLifetime;
    }

    /**
     * Sets the value of the insuranceLifetime property.
     *
     */
    public void setInsuranceLifetime(int value) {
        this.insuranceLifetime = value;
    }

}