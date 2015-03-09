package bg.hotel.services.impl;

import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import bg.hotel.services.ReceptionService;

@Named(value="receptionService")
@Transactional(value=TxType.SUPPORTS)
public class ReceptionServiceImpl implements ReceptionService{

}
