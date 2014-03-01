--------------------------------------------------------
-- Script to create XDM user for the examples in 
-- Oracle ADF Enterprise Application Development - Made Simple
-- ISBN 978-1-849681-88-9
-- (c) Sten Vesterli 2011, sten@vesterli.com
-- www.enterpriseadf.com, www.vesterli.com
--------------------------------------------------------
create user xdm identified by xdm;
grant connect, resource to xdm;