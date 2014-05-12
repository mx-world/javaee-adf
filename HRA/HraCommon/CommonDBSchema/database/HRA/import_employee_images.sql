--Proc to import the images

CREATE OR REPLACE PROCEDURE import_image(filename IN VARCHAR2,employee_id in NUMBER ) AS
newId NUMBER;
BEGIN
  INSERT
  INTO images(image_id,  image)
  VALUES(-1,   chr(47)||'images'||chr(47)||filename) returning image_id
  INTO newId;

  if employee_id is not null then 
    insert into image_usages(image_id, usage_type, default_image, associated_id) values(newId, 'E','Y', employee_id);
  end if;
  
END import_image;
/


--Run the import

Begin

import_image('j0431601.png',100);
import_image('j0431614.png',101);
import_image('j0431640.png',102);
import_image('j0431641.png',103);
import_image('j0432609.png',104);
import_image('j0432610.png',105);
import_image('j0432611.png',106);
import_image('j0432612.png',107);
import_image('j0432621.png',108);
import_image('j0432622.png',109);
import_image('j0432623.png',110);
import_image('j0432624.png',111);
import_image('j0432625.png',112);
import_image('j0432626.png',113);
import_image('j0432657.png',114);
import_image('j0433926.png',115);
import_image('j0433929.png',116);
import_image('j0433930.png',117);
import_image('j0433931.png',118);
import_image('j0433932.png',119);
import_image('j0433935.png',120);
import_image('j0433936.png',121);
import_image('j0433937.png',122);
import_image('j0433946.png',123);
import_image('j0433950.png',124);
import_image('j0433953.png',125);
import_image('j0433954.png',126);
import_image('j0433955.png',127);
import_image('j0433957.png',128);
import_image('j0433958.png',129);
import_image('j0433959.png',130);
import_image('j0433960.png',131);
import_image('j0434873.png',132);
import_image('j0434875.png',133);
import_image('j0434876.png',134);
import_image('j0434877.png',135);
import_image('j0434878.png',136);
import_image('j0434879.png',137);
import_image('j0434880.png',138);
import_image('j0434881.png',139);
import_image('j0434882.png',140);
import_image('j0434883.png',141);
import_image('j0434884.png',142);
import_image('j0434885.png',143);
import_image('j0434886.png',144);
import_image('j0434887.png',145);
import_image('j0434888.png',146);
import_image('j0434889.png',147);
import_image('j0434890.png',148);
import_image('j0434891.png',149);
import_image('j0434894.png',150);
import_image('j0434895.png',151);
import_image('j0434896.png',152);
import_image('j0434897.png',153);
import_image('j0434898.png',154);
import_image('j0434899.png',155);
import_image('j0434900.png',156);
import_image('j0434901.png',157);
import_image('j0434902.png',158);
import_image('j0434903.png',159);
import_image('j0434904.png',160);
import_image('j0434905.png',161);
import_image('j0431601.png',162);
import_image('j0431614.png',163);
import_image('j0431640.png',164);
import_image('j0431641.png',165);
import_image('j0432609.png',166);
import_image('j0432610.png',167);
import_image('j0432611.png',168);
import_image('j0432612.png',169);
import_image('j0432621.png',170);
import_image('j0432622.png',171);
import_image('j0432623.png',172);
import_image('j0432624.png',173);
import_image('j0432625.png',174);
import_image('j0432626.png',175);
import_image('j0432657.png',176);
import_image('j0433926.png',177);
import_image('j0433929.png',178);
import_image('j0433930.png',179);
import_image('j0433931.png',180);
import_image('j0433932.png',181);
import_image('j0433935.png',182);
import_image('j0433936.png',183);
import_image('j0433937.png',184);
import_image('j0433946.png',185);
import_image('j0433950.png',186);
import_image('j0433953.png',187);
import_image('j0433954.png',188);
import_image('j0433955.png',189);
import_image('j0433957.png',190);
import_image('j0433958.png',191);
import_image('j0433959.png',192);
import_image('j0433960.png',193);
import_image('j0434873.png',194);
import_image('j0434875.png',195);
import_image('j0434876.png',196);
import_image('j0434877.png',197);
import_image('j0434878.png',198);
import_image('j0434879.png',199);
import_image('j0434880.png',200);
import_image('j0434881.png',201);
import_image('j0434882.png',202);
import_image('j0434883.png',203);
import_image('j0434884.png',204);
import_image('j0434885.png',205);
import_image('j0434886.png',206);
import_image('j0434887.png',207);
end;
/

commit;