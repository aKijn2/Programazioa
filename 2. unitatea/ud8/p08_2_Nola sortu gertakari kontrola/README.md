Leihoaren osagai grafiko bat entzuten jartzeko (gertaera kontrolatzeko) hiru urrats egin behar dira.
Adibidea: btnGarbitu() objektua sakatzean ekintzak metodoa exekutatzea nahi dugu.

- Objektua ekintza jakin bati buruz entzuten jarri behar da. Horretarako, objektuaren izena eta puntu bat jarriko ditugu. Konpiladoreak entzuten jartzeko erabil ditzakegun metodoak erakutsiko dizkigu, hau da, "listener" hitza duen guztia. Listener bat interfaze jakin bat inplementatzen duen objektu bat besterik ez da, osagai bat erlazionatzen ari dena, hark gertaera jakin bat gertatzen denean jakinaraz dezan.

Metodo bakoitzerako objektua non entzuten duen egiaztatuko dugu; nahi badugu, metodo hori hautatuko dugu.

Gure adibidean: btnGarbitu.addActionListener (ActionListener motako objektu baten instantziazioa);

- Parametro gisa, ActionListner inplementatzen duen klase bat pasatu behar dugu. Beraz, ActionListener interfazea inplementatzen duen klase bat egin behar dugu. Hau egiteko modu asko daude. Gehien erabiltzen den aukera behar ahala klasea egitea da (Klase Anonimoa), behean ikus daitekeen bezala.

- Horrela, saguarekin hautatzen den unean, objektu hori entzuten jartzen duen metodoa aukeratzen dugunean, metodo horrek interfaze hori inplementatzen duen objektu bat behar du argudio gisa. Beraz, interfaze horren metodo guztiak inplementatu dituen klase batekoa izango da. Metodo bakoitzak noiz egiten duen salto aztertu beharko litzateke, objektuaren gainean egingo den ekintzaren arabera.

Gure adibidean, ActionListener interfazeak metodo bakarra du: actionPerformed (ActionEvent e)

Metodo hori erabiliko da botoia sakatzean.

Metodo horretan, botoia sakatzean exekutatzea nahi dugun kodea idatziko da, gure adibidean:

```Java
public void actionPerformed(ActionEvent e)
{
	ekintza(e);
}
```

```Java
// Klase anonimoa:
btnGarbitu.addActionListener(new ActionListener()
{
   public void actionPerformed(ActionEvent e) {
	ekintza(e);
  }
});
```