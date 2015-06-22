package it.unibs.ing.fp.groupX.medicalclinic.aviability;

import it.unibs.ing.fp.groupX.medicalclinic.people.StaffMember;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe che implementa un periodo di disponibilità per un membro della clinica
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class AvailabilityPeriod implements Serializable{
	private Date startDay;
	private Date endDay;
	private Date startTime;
	private Date endTime;
	private StaffMember sm;
	private List<WeekDay> wDays = new ArrayList<WeekDay>();
	
	/**
	 * Costruttore
	 * @param startDay Giorno iniziale
	 * @param endDay	Giorno finale
	 * @param startTime Orario iniziale
	 * @param endTime Orario finale
	 * @param sm Membro dello staff
	 * @param wDays Lista dei giorni della settimana a cui si applica (può essere null)
	 */
	public AvailabilityPeriod (Date startDay, Date endDay, Date startTime, Date endTime, StaffMember sm, List<WeekDay> wDays)
	{
		this.startDay = startDay;
		this.endDay = endDay;
		this.startTime = startTime;
		this.endTime = endTime;
		
		this.sm = sm;
		
		if (wDays == null || (wDays != null && wDays.size() == 0))
			this.wDays = null;
		
		if (wDays != null)
			this.wDays.addAll(wDays);
	}
	
	/**
	 * Costruttore senza giorni della settimana
	 * @param startDay Giorno iniziale
	 * @param endDay	Giorno finale
	 * @param startTime Orario iniziale
	 * @param endTime Orario finale
	 * @param sm Membro dello staff
	 */
	public AvailabilityPeriod(Date startDay, Date endDay, Date startTime, Date endTime, StaffMember sm) 
	{
		this(startDay, endDay, startTime, endTime, sm, null);
	}
	
	/**
	 * @return the startDay
	 */
	public Date getStartDay() {
		return startDay;
	}

	/**
	 * @return the endDay
	 */
	public Date getEndDay() {
		return endDay;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @return the sm
	 */
	public StaffMember getSm() {
		return sm;
	}

	/**
	 * @return the wDays
	 */
	public List<WeekDay> getwDays() {
		return wDays;
	}

	/**
	 * Ritorna true se la data è compatibile con il periodo
	 * @param d Data
	 * @param time Orario
	 * @return true: ok, false altrimenti
	 */
	public boolean compatibleWith (Date d, Date time)
	{
		if (d.compareTo(startDay)>=0 && d.compareTo(endDay)<=0)
		{
			if (time.compareTo(startTime)>=0 && time.compareTo(endTime)<=0)
			{
				if (wDays != null && wDays.contains(WeekDay.getWeekDay(d)))
				{
					return true;
				}
				else if (wDays == null)
				{
					return true;
				}
			}
		}


		return false;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		AvailabilityPeriod p = (AvailabilityPeriod) obj;
		
		if (p.startDay.equals(this.startDay) && p.endDay.equals(this.endDay) && p.startTime.equals(this.startTime) && p.endTime.equals(this.endTime) && p.sm.equals(this.sm) && this.wDays.equals(p.wDays))
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString ()
	{
		StringBuffer buf = new StringBuffer();
		
		buf.append(Utilities.dateToString(startDay) + " - ");
		buf.append(Utilities.dateToString(endDay) + "   ");
		buf.append(Utilities.timeInDateToString(startTime) + " - ");
		buf.append(Utilities.timeInDateToString(endTime) + "\n");
		buf.append(sm.toString());
		
		return buf.toString();
	}

}
