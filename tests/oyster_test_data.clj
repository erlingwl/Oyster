(ns oyster_test_data)

(def trlist [
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["15/01/10"]}
                {:tag :td, :attrs nil, :content ["08:50"]}
                {:tag :td, :attrs nil, :content ["Wimbledon"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["20.30"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:27"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:25"]}
                {:tag :td, :attrs nil, :content ["Waterloo (Bkloo, Nthn, W&C Lines)"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["22.20"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:07"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:07"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Auto top-up"]}
                {:tag :td, :attrs nil, :content ["20.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["24.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["14/01/10"]}
                {:tag :td, :attrs nil, :content ["18:29"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["4.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18:18"]}
                {:tag :td, :attrs nil, :content ["Waterloo (Bkloo, Nthn, W&C Lines) "]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["3.40"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["1.70"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["17:56"]}
                {:tag :td, :attrs nil, :content ["Wimbledon"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["1.70"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:43"]}
                {:tag :td, :attrs nil, :content ["Wimbledon"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["7.70"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:20"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["5.40"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:15"]}
                {:tag :td, :attrs nil, :content ["Waterloo (Bkloo, Nthn, W&C Lines)"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["9.60"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:05"]}
                {:tag :td, :attrs nil, :content ["Goodge Street "]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["5.40"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["13/01/10"]}
                {:tag :td, :attrs nil, :content ["18:29"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["11.40"]}
                ]}
            ])

(def nondatestrlist [
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:27"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:25"]}
                {:tag :td, :attrs nil, :content ["Waterloo (Bkloo, Nthn, W&C Lines)"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["22.20"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:07"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["14/01/10"]}
                {:tag :td, :attrs nil, :content ["18:29"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["4.00"]}
                ]}
            ])

(def trlistwithtopup [
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["15/01/10"]}
                {:tag :td, :attrs nil, :content ["08:50"]}
                {:tag :td, :attrs nil, :content ["Wimbledon"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["20.30"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:27"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:25"]}
                {:tag :td, :attrs nil, :content ["Waterloo (Bkloo, Nthn, W&C Lines)"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["22.20"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:07"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:07"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Auto top-up"]}
                {:tag :td, :attrs nil, :content ["20.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["24.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["14/01/10"]}
                {:tag :td, :attrs nil, :content ["18:29"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["4.00"]}
                ]}
            ])

(def trwithlotsofshit [{:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["14/01/10"]}
                {:tag :td, :attrs nil, :content ["18:29"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["4.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18:18"]}
                {:tag :td, :attrs nil, :content ["Waterloo (Bkloo, Nthn, W&C Lines) "]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["3.40"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["1.70"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["17:56"]}
                {:tag :td, :attrs nil, :content ["Wimbledon"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["1.70"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:43"]}
                {:tag :td, :attrs nil, :content ["Wimbledon"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["2.30"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["7.70"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:20"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["5.40"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:15"]}
                {:tag :td, :attrs nil, :content ["Waterloo (Bkloo, Nthn, W&C Lines)"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["9.60"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:05"]}
                {:tag :td, :attrs nil, :content ["Goodge Street "]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["5.40"]}
                ]}
               {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["01/01/10"]}
                {:tag :td, :attrs nil, :content ["08:05"]}
                {:tag :td, :attrs nil, :content ["Goodge Street "]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["11.40"]}
                ]}
            ])

(def nondatestrlistwithoutdate [
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:27"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:25"]}
                {:tag :td, :attrs nil, :content ["Waterloo (Bkloo, Nthn, W&C Lines)"]}
                {:tag :td, :attrs nil, :content ["Exit"]}
                {:tag :td, :attrs nil, :content ["4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["22.20"]}
                ]}
              {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:07"]}
                {:tag :td, :attrs nil, :content ["Goodge Street"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-6.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]}
            ])

(def trwithfare {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content ["01/01/01"]}
                {:tag :td, :attrs nil, :content ["08:27"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]})

(def trwithoutdate {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:27"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Entry"]}
                {:tag :td, :attrs nil, :content ["-4.20"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["18.00"]}
                ]})

(def trwithtopup {:tag :tr, :attrs nil, :content [
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["08:27"]}
                {:tag :td, :attrs nil, :content ["London Terminals"]}
                {:tag :td, :attrs nil, :content ["Auto top-up"]}
                {:tag :td, :attrs nil, :content ["            20.00"]}
                {:tag :td, :attrs nil, :content [""]}
                {:tag :td, :attrs nil, :content ["24.00"]}
                ]})

(def select-card-form "<form action=\"/oyster/selectCard.do\" method=\"post\" id=\"selectCardForm\">
                          <input type=\"text\" style=\"display: none;\" value=\"input\" name=\"method\"/>
                          <label for=\"select_card_no\">Card no:</label>
                          <select onchange=\"null\" onfocus=\"null\" id=\"select_card_no\" name=\"cardId\">
                            <option value=\"\">Select card number</option>
                            <option value=\"12345\">12345</option>
                            <option value=\"6789\">6789</option></select>
                          <input type=\"submit\" class=\"oysterbutton\" value=\"Go\"/>
                          <input type=\"hidden\" value=\"9-5-1234E\" name=\"123456789\"/>
                      </form>")
