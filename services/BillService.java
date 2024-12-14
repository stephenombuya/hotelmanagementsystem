@Service
class BillService {
    private final BillRepository billRepository;

    BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Optional<Bill> getBillById(int id) {
        return billRepository.findById(id);
    }

    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    public void deleteBill(int id) {
        billRepository.deleteById(id);
    }

    public Bill updateBill(int id, Bill updatedBill) {
        return billRepository.findById(id).map(bill -> {
            bill.setAmount(updatedBill.getAmount());
            bill.setPaid(updatedBill.isPaid());
            return billRepository.save(bill);
        }).orElseThrow(() -> new RuntimeException("Bill not found"));
    }
}
