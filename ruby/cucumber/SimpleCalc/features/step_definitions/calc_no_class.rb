require 'rspec/expectations' 

Given /the addend is (\d+)/ do |addend|
  @addend = addend.to_i
end

And /the augend is (\d+)/ do |augend|
  @augend = augend.to_i
end

When /(\w+) is applied/ do |operator|
  @operator = operator
end

Then /the result is (\d+)/ do |result|
  if (@operator == "plus")
    result.to_i.should == @addend + @augend
  else
    abort "Unsupported operator"
  end
end

