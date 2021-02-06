//for charity, sponsorship, fund raising.sol
pragma solidity >=0.4.22 <0.6.0;

contract Cart2new {
    uint public dataprice;
    address payable public dataowner;
    address payable public dataconsumer;
    address payable public miscellaneous;

    enum State { 
        Create, Lock, Release, Inactive 
    }
    
    State public state;

    modifier condition(bool cndn) {
        require(cndn);
        _;
    }

    modifier onlydataconsumer() {
        require(msg.sender == dataconsumer,"Only dataconsumer can execure it!");
        _;
    }

    modifier onlydataowner() {
        require(msg.sender == dataowner,"Only dataowner can perform this operation!");
        _;
    }

    modifier inState(State s) {
        require(state == state, "Invalid State!");
        _;
    }

    event Cancelled();
    event PurchaseConfirmed();
    event ItemAccessed(string datawhat, string conditions, string purpose, address dataowneraddr, uint reward);
    event PayOwner();

    constructor() public payable {
        dataowner = msg.sender;
        dataprice = msg.value / 2;
        require((2 * dataprice) == msg.value, "Please provide even number!");
        miscellaneous = 0x71129A80fE77492D82DaFE55EE046c850E809006;    //address to be used for donation/sponshorship/charity
    }

    function cancel() public onlydataowner inState(State.Create) {
        emit Cancelled();
        state = State.Inactive;
        dataowner.transfer(address(this).balance);
    }

    function confirmPurchase() public inState(State.Create) condition(msg.value == (2 * dataprice)) payable {
        emit PurchaseConfirmed();
        dataconsumer = msg.sender;
        state = State.Lock;
    }

    function confirmAccessed (string memory datawhat, string memory conditions, string memory purpose) public onlydataconsumer inState(State.Lock) {
        emit ItemAccessed(datawhat, conditions, purpose, dataowner, dataprice);
        state = State.Release;
        dataconsumer.transfer(dataprice);
        dataowner.transfer(2 * dataprice);
        miscellaneous.transfer(dataprice);
    }
}