
package com.netcracker.atm.bank;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.netcracker.atm.bank package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCardByCardNumberResponse_QNAME = new QName("http://bank.atm.netcracker.com/", "getCardByCardNumberResponse");
    private final static QName _CheckDateResponse_QNAME = new QName("http://bank.atm.netcracker.com/", "checkDateResponse");
    private final static QName _GetCurrentBalanceResponse_QNAME = new QName("http://bank.atm.netcracker.com/", "getCurrentBalanceResponse");
    private final static QName _CheckDate_QNAME = new QName("http://bank.atm.netcracker.com/", "checkDate");
    private final static QName _GetCardByCardNumber_QNAME = new QName("http://bank.atm.netcracker.com/", "getCardByCardNumber");
    private final static QName _GetCurrentBalance_QNAME = new QName("http://bank.atm.netcracker.com/", "getCurrentBalance");
    private final static QName _CheckPinResponse_QNAME = new QName("http://bank.atm.netcracker.com/", "checkPinResponse");
    private final static QName _Deposite_QNAME = new QName("http://bank.atm.netcracker.com/", "deposite");
    private final static QName _WithdrawResponse_QNAME = new QName("http://bank.atm.netcracker.com/", "withdrawResponse");
    private final static QName _Withdraw_QNAME = new QName("http://bank.atm.netcracker.com/", "withdraw");
    private final static QName _Card_QNAME = new QName("http://bank.atm.netcracker.com/", "card");
    private final static QName _DepositeResponse_QNAME = new QName("http://bank.atm.netcracker.com/", "depositeResponse");
    private final static QName _CheckPin_QNAME = new QName("http://bank.atm.netcracker.com/", "checkPin");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.netcracker.atm.bank
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCardByCardNumber }
     * 
     */
    public GetCardByCardNumber createGetCardByCardNumber() {
        return new GetCardByCardNumber();
    }

    /**
     * Create an instance of {@link GetCurrentBalance }
     * 
     */
    public GetCurrentBalance createGetCurrentBalance() {
        return new GetCurrentBalance();
    }

    /**
     * Create an instance of {@link CheckPinResponse }
     * 
     */
    public CheckPinResponse createCheckPinResponse() {
        return new CheckPinResponse();
    }

    /**
     * Create an instance of {@link GetCardByCardNumberResponse }
     * 
     */
    public GetCardByCardNumberResponse createGetCardByCardNumberResponse() {
        return new GetCardByCardNumberResponse();
    }

    /**
     * Create an instance of {@link GetCurrentBalanceResponse }
     * 
     */
    public GetCurrentBalanceResponse createGetCurrentBalanceResponse() {
        return new GetCurrentBalanceResponse();
    }

    /**
     * Create an instance of {@link CheckDateResponse }
     * 
     */
    public CheckDateResponse createCheckDateResponse() {
        return new CheckDateResponse();
    }

    /**
     * Create an instance of {@link CheckDate }
     * 
     */
    public CheckDate createCheckDate() {
        return new CheckDate();
    }

    /**
     * Create an instance of {@link CheckPin }
     * 
     */
    public CheckPin createCheckPin() {
        return new CheckPin();
    }

    /**
     * Create an instance of {@link Deposite }
     * 
     */
    public Deposite createDeposite() {
        return new Deposite();
    }

    /**
     * Create an instance of {@link WithdrawResponse }
     * 
     */
    public WithdrawResponse createWithdrawResponse() {
        return new WithdrawResponse();
    }

    /**
     * Create an instance of {@link Card }
     * 
     */
    public Card createCard() {
        return new Card();
    }

    /**
     * Create an instance of {@link DepositeResponse }
     * 
     */
    public DepositeResponse createDepositeResponse() {
        return new DepositeResponse();
    }

    /**
     * Create an instance of {@link Withdraw }
     * 
     */
    public Withdraw createWithdraw() {
        return new Withdraw();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardByCardNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "getCardByCardNumberResponse")
    public JAXBElement<GetCardByCardNumberResponse> createGetCardByCardNumberResponse(GetCardByCardNumberResponse value) {
        return new JAXBElement<GetCardByCardNumberResponse>(_GetCardByCardNumberResponse_QNAME, GetCardByCardNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "checkDateResponse")
    public JAXBElement<CheckDateResponse> createCheckDateResponse(CheckDateResponse value) {
        return new JAXBElement<CheckDateResponse>(_CheckDateResponse_QNAME, CheckDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "getCurrentBalanceResponse")
    public JAXBElement<GetCurrentBalanceResponse> createGetCurrentBalanceResponse(GetCurrentBalanceResponse value) {
        return new JAXBElement<GetCurrentBalanceResponse>(_GetCurrentBalanceResponse_QNAME, GetCurrentBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "checkDate")
    public JAXBElement<CheckDate> createCheckDate(CheckDate value) {
        return new JAXBElement<CheckDate>(_CheckDate_QNAME, CheckDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardByCardNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "getCardByCardNumber")
    public JAXBElement<GetCardByCardNumber> createGetCardByCardNumber(GetCardByCardNumber value) {
        return new JAXBElement<GetCardByCardNumber>(_GetCardByCardNumber_QNAME, GetCardByCardNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "getCurrentBalance")
    public JAXBElement<GetCurrentBalance> createGetCurrentBalance(GetCurrentBalance value) {
        return new JAXBElement<GetCurrentBalance>(_GetCurrentBalance_QNAME, GetCurrentBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "checkPinResponse")
    public JAXBElement<CheckPinResponse> createCheckPinResponse(CheckPinResponse value) {
        return new JAXBElement<CheckPinResponse>(_CheckPinResponse_QNAME, CheckPinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deposite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "deposite")
    public JAXBElement<Deposite> createDeposite(Deposite value) {
        return new JAXBElement<Deposite>(_Deposite_QNAME, Deposite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "withdrawResponse")
    public JAXBElement<WithdrawResponse> createWithdrawResponse(WithdrawResponse value) {
        return new JAXBElement<WithdrawResponse>(_WithdrawResponse_QNAME, WithdrawResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Withdraw }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "withdraw")
    public JAXBElement<Withdraw> createWithdraw(Withdraw value) {
        return new JAXBElement<Withdraw>(_Withdraw_QNAME, Withdraw.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "card")
    public JAXBElement<Card> createCard(Card value) {
        return new JAXBElement<Card>(_Card_QNAME, Card.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "depositeResponse")
    public JAXBElement<DepositeResponse> createDepositeResponse(DepositeResponse value) {
        return new JAXBElement<DepositeResponse>(_DepositeResponse_QNAME, DepositeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.atm.netcracker.com/", name = "checkPin")
    public JAXBElement<CheckPin> createCheckPin(CheckPin value) {
        return new JAXBElement<CheckPin>(_CheckPin_QNAME, CheckPin.class, null, value);
    }

}
