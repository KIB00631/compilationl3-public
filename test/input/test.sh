./rm.sh
ls | grep '\.l' | xargs -I{} java -cp ../../out/production/compilationl3-public Compiler {}

#java -cp ../../out/production/compilationl3-public Compiler "inf1.l"

for file in *.* ;
do
if [ "${file#*.}" != "l" ] && [ "${file#*.}" != "sh" ] && [ "${file#*.}" != "sc" ];
then
	./cmp.sh ${file%%.*} ${file#*.}
fi
done